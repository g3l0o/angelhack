package app.meat.com.m_eat;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rogelio Rivera on 7/8/2017.
 */

public class Vendedor implements Parcelable{
    private String ApMaterno;
    private String ApPaterno;
    private String Nombre;
    private Long id;
    private String Nacionalidad;

    public Vendedor(String apMaterno, String apPaterno, String nombre, Long id, String nacionalidad) {
        ApMaterno = apMaterno;
        ApPaterno = apPaterno;
        Nombre = nombre;
        Nacionalidad = nacionalidad;

        this.id = id;
    }

    public Vendedor() {
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        Nacionalidad = nacionalidad;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApMaterno() {
        return ApMaterno;
    }

    public void setApMaterno(String apMaterno) {
        ApMaterno = apMaterno;
    }

    public String getApPaterno() {
        return ApPaterno;
    }

    public void setApPaterno(String apPaterno) {
        ApPaterno = apPaterno;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFullName(){return getNombre() + " " + getApPaterno();}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ApMaterno);
        dest.writeString(this.ApPaterno);
        dest.writeString(this.Nombre);
        dest.writeValue(this.id);
        dest.writeString(this.Nacionalidad);
    }

    protected Vendedor(Parcel in) {
        this.ApMaterno = in.readString();
        this.ApPaterno = in.readString();
        this.Nombre = in.readString();
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.Nacionalidad = in.readString();
    }

    public static final Creator<Vendedor> CREATOR = new Creator<Vendedor>() {
        @Override
        public Vendedor createFromParcel(Parcel source) {
            return new Vendedor(source);
        }

        @Override
        public Vendedor[] newArray(int size) {
            return new Vendedor[size];
        }
    };
}
