package app.meat.com.m_eat;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rogelio Rivera on 7/9/2017.
 */

public class ProductHolder extends RecyclerView.ViewHolder {
    CardView cv;
    ImageView productLogo;
    TextView productName;
    TextView vendorName;

    View view;

    ProductHolder(View v){
        super(v);
        view = v;
        cv = (CardView) v.findViewById(R.id.product_card_view);
        productLogo = (ImageView) v.findViewById(R.id.card_view_product_logo);
        productName = (TextView) v.findViewById(R.id.card_view_main_dish);
        vendorName = (TextView) v.findViewById(R.id.card_view_vendor_name);

    }
}
