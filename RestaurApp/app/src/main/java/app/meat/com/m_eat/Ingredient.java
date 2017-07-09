package app.meat.com.m_eat;

import android.os.Parcelable;

/**
 * Created by Rogelio Rivera on 7/8/2017.
 */

public class Ingredient{
    private String Nombre;

    public Ingredient(String name){
        this.Nombre = name;
    }

    public Ingredient() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
