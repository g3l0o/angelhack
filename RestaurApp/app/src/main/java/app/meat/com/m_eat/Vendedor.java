package app.meat.com.m_eat;

/**
 * Created by Rogelio Rivera on 7/8/2017.
 */

public class Vendedor {
    private String ApMaterno;
    private String ApPaterno;
    private String Nombre;

    public Vendedor(String apMaterno, String apPaterno, String nombre) {
        ApMaterno = apMaterno;
        ApPaterno = apPaterno;
        Nombre = nombre;
    }

    public Vendedor() {
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
}
