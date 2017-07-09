package app.meat.com.m_eat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class FoodDetails extends AppCompatActivity {

    public static String EXTRA_VENDOR = "VENDOR";

    Product product;

    TextView mMainDish;
    TextView mVendorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        product = getIntent().getParcelableExtra(EXTRA_VENDOR);

        mMainDish = (TextView) findViewById(R.id.main_dish_detail);
        mVendorName = (TextView) findViewById(R.id.vendor_name_detail);

        mMainDish.setText(product.getNombre());
        mVendorName.setText(product.getVendedor().getFullName());
    }


}
