package app.meat.com.m_eat;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rogelio Rivera on 7/9/2017.
 */

public class Idioma implements Parcelable {
    private String Nombre;

    public Idioma(String nombre) {
        Nombre = nombre;
    }

    public Idioma() {
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

    protected Idioma(Parcel in) {
        this.Nombre = in.readString();
    }

    public static final Parcelable.Creator<Idioma> CREATOR = new Parcelable.Creator<Idioma>() {
        @Override
        public Idioma createFromParcel(Parcel source) {
            return new Idioma(source);
        }

        @Override
        public Idioma[] newArray(int size) {
            return new Idioma[size];
        }
    };
}
