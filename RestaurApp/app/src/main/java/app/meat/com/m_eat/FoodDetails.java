package app.meat.com.m_eat;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.ByteArrayInputStream;

public class FoodDetails extends AppCompatActivity {

    public static String EXTRA_VENDOR = "VENDOR";
    final long ONE_MEGABYTE = 1024 * 1024;

    StorageReference mStorageReference;

    Product product;

    TextView mMainDish;
    TextView mVendorName;
    TextView mPrice;
    TextView mHorario;
    TextView mNacionalidad;

    ImageView mDishImg;

    Resources mResources;

    private final String GS_URL = "gs://m-eat-342e8.appspot.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mResources = getResources();

        mStorageReference = getStorageReference(GS_URL);

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
        mDishImg = (ImageView) findViewById(R.id.header_image);
        mHorario = (TextView) findViewById(R.id.horario);
        mPrice = (TextView) findViewById(R.id.precio);
        mNacionalidad = (TextView) findViewById(R.id.vendor_name_nacionality);

        mMainDish.setText(product.getNombre());
        mVendorName.setText(product.getVendedor().getFullName());
        mPrice.setText("$ "+ String.valueOf(product.getPrecio()) + "°°");
        //mNacionalidad.setText(product.getVendedor().getNacionalidad());


        getSpecificImageToDish(mStorageReference, product.getImagen());
    }

    private StorageReference getStorageReference(String connectionURL){
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReferenceFromUrl(connectionURL);
        return storageReference;
    }

    private void getSpecificImageToDish(StorageReference storageReference, String imageName){
        StorageReference storageReferenceImage = storageReference.child(imageName);
        BitmapDrawable bitmapDrawable = null;
        storageReferenceImage.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            Bitmap bitmap = null;
            @Override
            public void onSuccess(byte[] bytes) {
                ByteArrayInputStream imageStream = new ByteArrayInputStream(bytes);
                bitmap= BitmapFactory.decodeStream(imageStream);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                mDishImg.setImageDrawable(bitmapDrawable);
            }
        });
    }
}
