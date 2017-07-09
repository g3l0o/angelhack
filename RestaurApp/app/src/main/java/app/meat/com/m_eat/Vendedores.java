package app.meat.com.m_eat;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by EduardoYair on 09/07/2017.
 */

public class Vendedores implements Parcelable {
    private String ApPaterno;
    private String ApMaterno;
    private String Categoria;
    private ArrayList<Cocina> Cocinas;
    private int edad;
    private String Experiencia;
    private ArrayList<Horario> Horarios;
    private ArrayList<Idioma> Idiomas;
    private float Latitud;
    private float Longitud;
    private String Nacionalidad;
    private String Nombre;
    private String Pais;
    private String Sexo;
    private String Tarjeta;
    private ArrayList<Telefono> Telefonos;

    public Vendedores(){

    }

    protected Vendedores(Parcel in) {
        ApPaterno = in.readString();
        ApMaterno = in.readString();
        Categoria = in.readString();
        edad = in.readInt();
        Experiencia = in.readString();
        Latitud = in.readFloat();
        Longitud = in.readFloat();
        Nacionalidad = in.readString();
        Nombre = in.readString();
        Pais = in.readString();
        Sexo = in.readString();
        Tarjeta = in.readString();
    }

    public static final Creator<Vendedores> CREATOR = new Creator<Vendedores>() {
        @Override
        public Vendedores createFromParcel(Parcel in) {
            return new Vendedores(in);
        }

        @Override
        public Vendedores[] newArray(int size) {
            return new Vendedores[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ApPaterno);
        dest.writeString(ApMaterno);
        dest.writeString(Categoria);
        dest.writeInt(edad);
        dest.writeString(Experiencia);
        dest.writeFloat(Latitud);
        dest.writeFloat(Longitud);
        dest.writeString(Nacionalidad);
        dest.writeString(Nombre);
        dest.writeString(Pais);
        dest.writeString(Sexo);
        dest.writeString(Tarjeta);
    }
}
