package app.meat.com.m_eat;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rogelio Rivera on 7/8/2017.
 */

public class Ingredient implements Parcelable{
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Nombre);
    }

    protected Ingredient(Parcel in) {
        this.Nombre = in.readString();
    }

    public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel source) {
            return new Ingredient(source);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };
}
