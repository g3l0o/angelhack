package app.meat.com.m_eat;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rogelio Rivera on 7/9/2017.
 */

public class Idiomas implements Parcelable {
    private String Nombre;

    public Idiomas(String nombre) {
        Nombre = nombre;
    }

    public Idiomas() {
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

    protected Idiomas(Parcel in) {
        this.Nombre = in.readString();
    }

    public static final Creator<Idiomas> CREATOR = new Creator<Idiomas>() {
        @Override
        public Idiomas createFromParcel(Parcel source) {
            return new Idiomas(source);
        }

        @Override
        public Idiomas[] newArray(int size) {
            return new Idiomas[size];
        }
    };
}
