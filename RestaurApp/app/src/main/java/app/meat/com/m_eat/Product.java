package app.meat.com.m_eat;

import java.util.ArrayList;

/**
 * Created by Rogelio Rivera on 7/8/2017.
 */

public class Product {
    private Boolean Disponible;
    private String Imagen;
    private ArrayList<Ingredient> Ingredientes;
    private String Nombre;
    private Long Precio;
    private Vendedor Vendedor;
    private String TamPorcion;

    public Product() {
    }

    public Product(Boolean disponible, String imagen, ArrayList<Ingredient> ingredientes, String nombre, Long precio, app.meat.com.m_eat.Vendedor vendedor, String tamPorcion) {
        Disponible = disponible;
        Imagen = imagen;
        Ingredientes = ingredientes;
        Nombre = nombre;
        Precio = precio;
        Vendedor = vendedor;
        TamPorcion = tamPorcion;
    }

    public Boolean getDisponible() {
        return Disponible;
    }

    public void setDisponible(Boolean disponible) {
        Disponible = disponible;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public ArrayList<Ingredient> getIngredientes() {
        return Ingredientes;
    }

    public void setIngredientes(ArrayList<Ingredient> ingredientes) {
        Ingredientes = ingredientes;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Long getPrecio() {
        return Precio;
    }

    public void setPrecio(Long precio) {
        Precio = precio;
    }

    public app.meat.com.m_eat.Vendedor getVendedor() {
        return Vendedor;
    }

    public void setVendedor(app.meat.com.m_eat.Vendedor vendedor) {
        Vendedor = vendedor;
    }

    public String getTamPorcion() {
        return TamPorcion;
    }

    public void setTamPorcion(String tamPorcion) {
        TamPorcion = tamPorcion;
    }
}


