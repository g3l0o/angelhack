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
    private ArrayList<Cocina> Cocina;
    private Long Edad;
    private String Experiencia;
    private ArrayList<Horario> Horarios;
    private ArrayList<app.meat.com.m_eat.Idiomas> Idiomas;
    private float Latitud;
    private float Longitud;
    private String Nacionalidad;
    private String Nombres;
    private String Pais;
    private String Sexo;
    private String Tarjeta;
    private String Imagen;
    private ArrayList<Telefono> Telefonos;

    public Vendedores() {
    }

    public Vendedores(String apPaterno, String apMaterno, String categoria, ArrayList<app.meat.com.m_eat.Cocina> cocina, Long edad, String experiencia, ArrayList<Horario> horarios, ArrayList<app.meat.com.m_eat.Idiomas> idiomas, float latitud, float longitud, String nacionalidad, String nombres, String pais, String sexo, String tarjeta, String imagen, ArrayList<Telefono> telefonos) {
        ApPaterno = apPaterno;
        ApMaterno = apMaterno;
        Categoria = categoria;
        Cocina = cocina;
        Edad = edad;
        Experiencia = experiencia;
        Horarios = horarios;
        Idiomas = idiomas;
        Latitud = latitud;
        Longitud = longitud;
        Nacionalidad = nacionalidad;
        Nombres = nombres;
        Pais = pais;
        Sexo = sexo;
        Tarjeta = tarjeta;
        Imagen = imagen;
        Telefonos = telefonos;
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

    public ArrayList<app.meat.com.m_eat.Cocina> getCocina() {
        return Cocina;
    }

    public void setCocina(ArrayList<app.meat.com.m_eat.Cocina> cocina) {
        Cocina = cocina;
    }

    public Long getEdad() {
        return Edad;
    }

    public void setEdad(Long edad) {
        Edad = edad;
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

    public ArrayList<app.meat.com.m_eat.Idiomas> getIdiomas() {
        return Idiomas;
    }

    public void setIdiomas(ArrayList<app.meat.com.m_eat.Idiomas> idiomas) {
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

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ApPaterno);
        dest.writeString(this.ApMaterno);
        dest.writeString(this.Categoria);
        dest.writeTypedList(this.Cocina);
        dest.writeValue(this.Edad);
        dest.writeString(this.Experiencia);
        dest.writeTypedList(this.Horarios);
        dest.writeTypedList(this.Idiomas);
        dest.writeFloat(this.Latitud);
        dest.writeFloat(this.Longitud);
        dest.writeString(this.Nacionalidad);
        dest.writeString(this.Nombres);
        dest.writeString(this.Pais);
        dest.writeString(this.Sexo);
        dest.writeString(this.Tarjeta);
        dest.writeString(this.Imagen);
        dest.writeTypedList(this.Telefonos);
    }

    protected Vendedores(Parcel in) {
        this.ApPaterno = in.readString();
        this.ApMaterno = in.readString();
        this.Categoria = in.readString();
        this.Cocina = in.createTypedArrayList(app.meat.com.m_eat.Cocina.CREATOR);
        this.Edad = (Long) in.readValue(Long.class.getClassLoader());
        this.Experiencia = in.readString();
        this.Horarios = in.createTypedArrayList(Horario.CREATOR);
        this.Idiomas = in.createTypedArrayList(app.meat.com.m_eat.Idiomas.CREATOR);
        this.Latitud = in.readFloat();
        this.Longitud = in.readFloat();
        this.Nacionalidad = in.readString();
        this.Nombres = in.readString();
        this.Pais = in.readString();
        this.Sexo = in.readString();
        this.Tarjeta = in.readString();
        this.Imagen = in.readString();
        this.Telefonos = in.createTypedArrayList(Telefono.CREATOR);
    }

    public static final Creator<Vendedores> CREATOR = new Creator<Vendedores>() {
        @Override
        public Vendedores createFromParcel(Parcel source) {
            return new Vendedores(source);
        }

        @Override
        public Vendedores[] newArray(int size) {
            return new Vendedores[size];
        }
    };
}
