package com.example.gonzalo.tiendamovil;

import android.*;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QR extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView escanerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        PedirPermisos();

    }
    public void EscanerQR(View view)
    {
        escanerView = new ZXingScannerView(this);
        setContentView(escanerView);
        escanerView.setResultHandler(this);
        escanerView.startCamera();
    }


    public void PedirPermisos()
    {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
        } else {
            solicitarPermiso(android.Manifest.permission.CAMERA, "Sin el permiso", 1, this);
        }
    }

    public static void solicitarPermiso(final String permiso, String justificacion, final int requestCode, final Activity actividad) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(actividad, permiso)){
            new AlertDialog.Builder(actividad)
                    .setTitle("Solicitud de permiso")
                    .setMessage(justificacion)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            ActivityCompat.requestPermissions(actividad, new String[]{permiso}, requestCode);
                            dialog.dismiss();


                        }}).show();
        } else {
            ActivityCompat.requestPermissions(actividad,
                    new String[]{permiso}, requestCode);
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        escanerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Resultado del scanner");
        builder.setMessage("Resultado "+result.getText()+"\nFormato"+result.getBarcodeFormat()  );
        try{

            Uri uri = Uri.parse(result.getText());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

            AlertDialog alertDialog=builder.create();
            alertDialog.show();
            escanerView.resumeCameraPreview(this);


        }catch (Exception e){

            Toast.makeText(getApplicationContext(),"DA ERROR EN el handle", Toast.LENGTH_SHORT).show();
        }
    }
}
