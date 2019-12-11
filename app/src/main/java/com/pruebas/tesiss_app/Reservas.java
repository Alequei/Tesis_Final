package com.pruebas.tesiss_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Reservas extends AppCompatActivity {
    private ImageView imagen;
    private TextView nombre,precio,pago,nombredelpago;
    ImageView mapa;
    Dialog mydialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mydialog=new Dialog(this);
        setContentView(R.layout.activity_reservas);
        //Peluqueria
        String peluqueriaTitle=getIntent().getExtras().getString("title");
        String peluqueriaPrecio=getIntent().getExtras().getString("precio");
        int imagenurl=getIntent().getExtras().getInt("ImgUrl");
        pago=findViewById(R.id.pagotratmiento);
        nombredelpago=findViewById(R.id.nombrepago);
        mapa = findViewById(R.id.ubicaciones_id);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Reservas.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        //Peluqueria
        imagen=findViewById(R.id.imagenUrl);
        imagen.setImageResource(imagenurl);
        nombre = findViewById(R.id.nombretratamiento);
        nombre.setText(peluqueriaTitle);
        precio = findViewById(R.id.costoreserv);
        precio.setText(peluqueriaPrecio);
        pago.setText(precio.getText());
       nombredelpago.setText(nombre.getText());


    }
    public void tipopago(View view){
        TextView pagotarjeta,pagoefectivo;
        mydialog.setContentView(R.layout.dialogalert);
        pagoefectivo=(TextView) mydialog.findViewById(R.id.textView11);
        pagotarjeta=(TextView) mydialog.findViewById(R.id.textView12);

        pagoefectivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.dismiss();
            }
        });
        pagotarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Tarjeta.class);
                startActivity(intent);
                mydialog.dismiss();
            }
        });
        mydialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}
