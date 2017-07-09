package app.meat.com.m_eat;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EduardoYair on 09/07/2017.
 */

public class Horario implements Parcelable {

    private String horaFin;
    private String horaIn;

    public Horario() {
    }

    public Horario(String horaFin, String horaIn) {
        this.horaFin = horaFin;
        this.horaIn = horaIn;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.horaFin);
        dest.writeString(this.horaIn);
    }

    protected Horario(Parcel in) {
        this.horaFin = in.readString();
        this.horaIn = in.readString();
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
