package app.meat.com.m_eat;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Rogelio Rivera on 7/8/2017.
 */

public class Product implements Parcelable{
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.Disponible);
        dest.writeString(this.Imagen);
        dest.writeList(this.Ingredientes);
        dest.writeString(this.Nombre);
        dest.writeValue(this.Precio);
        dest.writeParcelable(this.Vendedor, flags);
        dest.writeString(this.TamPorcion);
    }

    protected Product(Parcel in) {
        this.Disponible = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.Imagen = in.readString();
        this.Ingredientes = new ArrayList<Ingredient>();
        in.readList(this.Ingredientes, Ingredient.class.getClassLoader());
        this.Nombre = in.readString();
        this.Precio = (Long) in.readValue(Long.class.getClassLoader());
        this.Vendedor = in.readParcelable(app.meat.com.m_eat.Vendedor.class.getClassLoader());
        this.TamPorcion = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}


