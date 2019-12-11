package com.pruebas.tesiss_app;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static List<class_pelequeria>getPeluqueria(){
        List<class_pelequeria> class_pelequerias =new ArrayList<>();
        class_pelequerias.add(new class_pelequeria("Tinte","S./30.00",R.drawable.peinado1));
        class_pelequerias.add(new class_pelequeria("Mechas","S./20.00",R.drawable.peinado2));
        class_pelequerias.add(new class_pelequeria("Modelado","S./15.00",R.drawable.peinado3));
        class_pelequerias.add(new class_pelequeria("Peinada","S./20.00",R.drawable.peinado4));
        class_pelequerias.add(new class_pelequeria("Tratamiento","S./20.00",R.drawable.peinado5));
        class_pelequerias.add(new class_pelequeria("Corte","S./20.00",R.drawable.peinado6));
        return  class_pelequerias;
    }
    public static  List<class_pelequeria>getTratamiento(){
        List<class_pelequeria> class_pelequerias =new ArrayList<>();
        class_pelequerias.add(new class_pelequeria("Fasial","S./30.00",R.drawable.tratamiento1));
        class_pelequerias.add(new class_pelequeria("Corporal","S./20.00",R.drawable.tratamiento2));
        class_pelequerias.add(new class_pelequeria("Masaje","S./15.00",R.drawable.tratamiento3));
       return  class_pelequerias;
    }
    public static  List<class_pelequeria>getestetica(){
        List<class_pelequeria> class_pelequerias =new ArrayList<>();
        class_pelequerias.add(new class_pelequeria("Maquillaje","S./30.00",R.drawable.estetica1));
        class_pelequerias.add(new class_pelequeria("Pestañas y Cejas","S./30.00",R.drawable.estetica2));
        class_pelequerias.add(new class_pelequeria("Manicura y Pedicura","S./20.00",R.drawable.estetica3));
        class_pelequerias.add(new class_pelequeria("Depilacion Hombres","S./15.00",R.drawable.estetica4));
        class_pelequerias.add(new class_pelequeria("Depilacion Mujeres","S./20.00",R.drawable.estetica5));
        return  class_pelequerias;
    }
}
