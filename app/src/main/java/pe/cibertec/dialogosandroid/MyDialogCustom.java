package pe.cibertec.dialogosandroid;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.NotificationCompat;
import android.view.View;

/**
 * Created by Android-SAB-PM on 16/07/2016.
 */
public class MyDialogCustom extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity()); //con getActivity() recupero el activity padre
        builder.setTitle("Titulo");
        builder.setMessage("Llamamos a un Activity");

        View view = getActivity().getLayoutInflater().inflate(R.layout.activity_main,null);
        builder.setView(view);

        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        return builder.create();
    }
}
