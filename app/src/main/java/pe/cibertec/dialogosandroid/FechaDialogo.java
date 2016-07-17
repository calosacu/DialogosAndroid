package pe.cibertec.dialogosandroid;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.Gravity;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


/**
 * Created by Android-SAB-PM on 16/07/2016.
 */
public class FechaDialogo extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    ListenerOyente listenerOyente;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int anio = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, anio, mes, dia);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Log.d("XXXX", "" + year);

/*        TextView txtFecha = (TextView) getActivity().findViewById(R.id.txtFecha);
        txtFecha.setText("" + dayOfMonth + "/" + monthOfYear + "/" + year);*/

        listenerOyente.setearfecha("" + dayOfMonth + "/" + monthOfYear + "/" + year);
    }

    //Declaracion de Interface
    interface ListenerOyente {
        //Declaracion de los metodos Abstractos
        public void setearfecha(String fecha);
    }//el que implemente esta interfas esta obligado a usar su metodo


    @Override
    public void onAttach(Activity activity) {
        //este fracmento se va atachar en este activy padre
        //se muestra antes de aparecer el dialogo
        super.onAttach(activity);

        listenerOyente = (ListenerOyente) activity; //Herencia inderecta
    }
}
