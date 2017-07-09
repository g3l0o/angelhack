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
    private int Edad;
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
    private String Imagen;
    private ArrayList<Telefono> Telefonos;


    public String getNombreCompleto(){
        return getNombre()+" "+getApPaterno()+" "+getApMaterno();
    }

}
