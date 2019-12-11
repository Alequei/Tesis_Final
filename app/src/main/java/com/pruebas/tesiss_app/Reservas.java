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
    private ImageView imagen,pagar;
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
        pagar=findViewById(R.id.tipodepago_id);
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

        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(Reservas.this,Tarjeta.class);
                startActivity(inten);
            }
        });
    }

}
