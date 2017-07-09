package app.meat.com.m_eat;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rogelio Rivera on 7/9/2017.
 */

public class Telefono implements Parcelable {
    private String Numero;

    public Telefono(String numero) {
        Numero = numero;
    }

    public Telefono() {
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }


    s@Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Numero);
    }

    protected Telefono(Parcel in) {
        this.Numero = in.readString();
    }

    public static final Parcelable.Creator<Telefono> CREATOR = new Parcelable.Creator<Telefono>() {
        @Override
        public Telefono createFromParcel(Parcel source) {
            return new Telefono(source);
        }

        @Override
        public Telefono[] newArray(int size) {
            return new Telefono[size];
        }
    };
}
