package app.meat.com.m_eat;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EduardoYair on 09/07/2017.
 */

public class Horario implements Parcelable {

    private double Hora_Fin;
    private double Hora_Inicio;

    public Horario(double hora_Fin, double hora_Inicio) {
        Hora_Fin = hora_Fin;
        Hora_Inicio = hora_Inicio;
    }

    public Horario() {
    }

    public double getHora_Fin() {
        return Hora_Fin;
    }

    public void setHora_Fin(double hora_Fin) {
        Hora_Fin = hora_Fin;
    }

    public double getHora_Inicio() {
        return Hora_Inicio;
    }

    public void setHora_Inicio(double hora_Inicio) {
        Hora_Inicio = hora_Inicio;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.Hora_Fin);
        dest.writeDouble(this.Hora_Inicio);
    }

    protected Horario(Parcel in) {
        this.Hora_Fin = in.readDouble();
        this.Hora_Inicio = in.readDouble();
    }

    public static final Creator<Horario> CREATOR = new Creator<Horario>() {
        @Override
        public Horario createFromParcel(Parcel source) {
            return new Horario(source);
        }

        @Override
        public Horario[] newArray(int size) {
            return new Horario[size];
        }
    };
}
