package pe.cibertec.dialogosandroid;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by Android-SAB-PM on 16/07/2016.
 */
public class HoraDialogo extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    ListenerOyente listenerOyente;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR);
        int minuto = calendar.get(Calendar.MINUTE);
        int segundo = calendar.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hora, minuto, DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Log.d("XXXX", "" + hourOfDay);
        //ejecuta el metodo
        listenerOyente.setarHora(hourOfDay, minute);
    }

    interface ListenerOyente {
        public void setarHora(int hora, int minuto);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        listenerOyente = (ListenerOyente) activity; //Herencia inderecta
    }
}
