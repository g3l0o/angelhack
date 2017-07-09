package app.meat.com.m_eat;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Rogelio Rivera on 7/9/2017.
 */

public class VendedoresHolder extends RecyclerView.ViewHolder {
    CardView cv;
    ImageView flagLogo;
    TextView vendorName;

    VendedoresHolder(View v){
        super(v);

        cv=(CardView) v.findViewById(R.id.flag_card_view);
        flagLogo=(ImageView) v.findViewById(R.id.card_view_flag_logo);
        vendorName=(TextView) v.findViewById(R.id.card_view_flag_name);

    }
}
