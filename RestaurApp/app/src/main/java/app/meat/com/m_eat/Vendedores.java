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
    private String Imagen;
    private ArrayList<Telefono> Telefonos;

    public Vendedores(String apPaterno, String apMaterno, String categoria, ArrayList<Cocina> cocinas, int edad, String experiencia, ArrayList<Horario> horarios, ArrayList<Idioma> idiomas, float latitud, float longitud, String nacionalidad, String nombre, String pais, String sexo, String tarjeta, String imagen, ArrayList<Telefono> telefonos) {
        ApPaterno = apPaterno;
        ApMaterno = apMaterno;
        Categoria = categoria;
        Cocinas = cocinas;
        this.edad = edad;
        Experiencia = experiencia;
        Horarios = horarios;
        Idiomas = idiomas;
        Latitud = latitud;
        Longitud = longitud;
        Nacionalidad = nacionalidad;
        Nombre = nombre;
        Pais = pais;
        Sexo = sexo;
        Tarjeta = tarjeta;
        Imagen = imagen;
        Telefonos = telefonos;
    }

    public Vendedores() {
    }

    public String getApPaterno() {
        return ApPaterno;
    }

    public void setApPaterno(String apPaterno) {
        ApPaterno = apPaterno;
    }

    public String getApMaterno() {
        return ApMaterno;
    }

    public void setApMaterno(String apMaterno) {
        ApMaterno = apMaterno;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public ArrayList<Cocina> getCocinas() {
        return Cocinas;
    }

    public void setCocinas(ArrayList<Cocina> cocinas) {
        Cocinas = cocinas;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getExperiencia() {
        return Experiencia;
    }

    public void setExperiencia(String experiencia) {
        Experiencia = experiencia;
    }

    public ArrayList<Horario> getHorarios() {
        return Horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        Horarios = horarios;
    }

    public ArrayList<Idioma> getIdiomas() {
        return Idiomas;
    }

    public void setIdiomas(ArrayList<Idioma> idiomas) {
        Idiomas = idiomas;
    }

    public float getLatitud() {
        return Latitud;
    }

    public void setLatitud(float latitud) {
        Latitud = latitud;
    }

    public float getLongitud() {
        return Longitud;
    }

    public void setLongitud(float longitud) {
        Longitud = longitud;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        Nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getTarjeta() {
        return Tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        Tarjeta = tarjeta;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public ArrayList<Telefono> getTelefonos() {
        return Telefonos;
    }

    public void setTelefonos(ArrayList<Telefono> telefonos) {
        Telefonos = telefonos;
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

    public String getNombreCompleto(){
        return getNombre()+" "+getApPaterno()+" "+getApMaterno();
    }

}
