package com.pruebas.tesiss_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class    Principal extends AppCompatActivity implements MovieItemClick {
    List<Slider> sliderList;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView peluqueria,tratamiento,estetica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        IniView();
        iniSlider();
        TodolosServicios();
        TodolosTratamiento();
        TodolosEstetica();

    }

    private void iniSlider() {
        //Carrusel de la pagina principal
        sliderList = new ArrayList<>();
        sliderList.add(new Slider(R.drawable.peinado1,"Tintes"));
        sliderList.add(new Slider(R.drawable.tratamiento3,"Majasajes"));
        sliderList.add(new Slider(R.drawable.estetica3,"Depilaciones"));
        sliderList.add(new Slider(R.drawable.estetica4,"Tratamietno Corporales"));
        sliderList.add(new Slider(R.drawable.peinado6,"Cortes"));
        SliderAdapter adapter = new SliderAdapter(this,sliderList);
        sliderpager.setAdapter(adapter);

        Timer time=new Timer();
        time.scheduleAtFixedRate(new sliderTimer(),4000,6000);
        indicator.setupWithViewPager(sliderpager,true);
    }

    private void IniView() {
        sliderpager = findViewById(R.id.viewPager);
        indicator = findViewById(R.id.indicator_id);
        peluqueria =findViewById(R.id.rv_peluqueria);
        tratamiento =findViewById(R.id.rv_tratamiento);
        estetica =findViewById(R.id.rv_estetica);
    }

    private void TodolosEstetica() {
        PeluqueriaAdapter esteticaadapter=new PeluqueriaAdapter(this,DataSource.getestetica(),this);
        estetica.setAdapter(esteticaadapter);
        estetica.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void TodolosTratamiento() {
        PeluqueriaAdapter tratamientoadapter=new PeluqueriaAdapter(this,DataSource.getTratamiento(),this);
        tratamiento.setAdapter(tratamientoadapter);
        tratamiento.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void TodolosServicios() {
        //RecycleView Peluqueria
        PeluqueriaAdapter peluqueriaAdapter=new PeluqueriaAdapter(this,DataSource.getPeluqueria(),this);
        peluqueria.setAdapter(peluqueriaAdapter);
        peluqueria.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    public void onMovieclick(class_pelequeria class_pelequeria, ImageView movilImagen) {
        Intent intent= new Intent(this,Reservas.class);
        //Datos Guardados de  Peluqueria
        intent.putExtra("title",class_pelequeria.getNombre());
        intent.putExtra("ImgUrl",class_pelequeria.getImagen());
        intent.putExtra("precio",class_pelequeria.getPrecio());
        //Invia animacion
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(Principal.this, movilImagen,"sharedName");


        startActivity(intent,options.toBundle());
        Toast.makeText(this,"Seleccion de  servicio de"+class_pelequeria.getNombre(),Toast.LENGTH_SHORT).show();

    }

    class sliderTimer extends TimerTask{

            @Override
            public void run() {
                Principal.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (sliderpager.getCurrentItem()<sliderList.size() - 1){
                            sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                        }else {
                            sliderpager.setCurrentItem(0);
                        }
                    }
                });
            }
        }
    }


