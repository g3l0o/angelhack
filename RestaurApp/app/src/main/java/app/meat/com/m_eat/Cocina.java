package app.meat.com.m_eat;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EduardoYair on 09/07/2017.
 */

public class Cocina implements Parcelable {

    private String Nombre;

    public Cocina(String name){
        this.Nombre = name;
    }

    public Cocina() {
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

    protected Cocina(Parcel in) {
        this.Nombre = in.readString();
    }

    public static final Creator<Cocina> CREATOR = new Creator<Cocina>() {
        @Override
        public Cocina createFromParcel(Parcel source) {
            return new Cocina(source);
        }

        @Override
        public Cocina[] newArray(int size) {
            return new Cocina[size];
        }
    };
}
