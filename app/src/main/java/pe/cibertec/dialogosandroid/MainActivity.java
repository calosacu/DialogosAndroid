package pe.cibertec.dialogosandroid;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FechaDialogo.ListenerOyente, HoraDialogo.ListenerOyente {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_AbrirDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Mi Primer Dialogo");
        //builder.setMessage("Voy aprobar el curso?");

        final String[] opciones = getResources().getStringArray(R.array.opcionesDialogo);

/*        builder.setSingleChoiceItems(opciones,2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("Valor Seleccionado: "+opciones[which]);
            }
        });*/
        //comentar Control + Shif + /


        boolean[] valores = {false, false, false};
        final List<String> seleccionados= new ArrayList<>();
        //seleccionados.add("OP1");
        //seleccionados.add("OP2");
        //seleccionados.add("OP3");

        builder.setMultiChoiceItems(opciones, valores, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                String sele=opciones[which];
                if(!seleccionados.contains(sele)){
                    seleccionados.add(sele);
                }
                if(!isChecked){
                    seleccionados.remove(sele);
                }
            }
        });

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("SI");
                //blucle para saber cuales fueron selecionado en seleccionado
                showToast(seleccionados.toString());
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("NO");
            }
        });

        //builder.show();
        builder.create().show();
    }

    private Toast mToast;

    private void showToast(String message) {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        mToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        mToast.show();
    }

    public void onClick_AbrirDialogosCustom(View view) {
        DialogFragment dialogFragment= new MyDialogCustom();
        dialogFragment.show(getSupportFragmentManager(),"custom");
    }

    public void onClick_SeleccionarFecha(View view) {
        DialogFragment dialogFragment= new FechaDialogo();
        dialogFragment.show(getSupportFragmentManager(),"fecha");
    }

    @Override
    public void setearfecha(String fecha) {
        TextView txtFecha = (TextView)findViewById(R.id.txtFecha);
        txtFecha.setText(fecha);
    }

    public void onClick_SeleccionarHora(View view) {
        DialogFragment dialogFragment= new HoraDialogo();
        dialogFragment.show(getSupportFragmentManager(),"hora");
    }

    @Override
    public void setarHora(int hora, int minuto) {
        TextView txtHora = (TextView)findViewById(R.id.txtHora);
        txtHora.setText(hora + ":" + minuto);
    }
}
