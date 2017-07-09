package app.meat.com.m_eat;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * Created by Rogelio Rivera on 7/9/2017.
 */

public class RVMenuAdapter extends RecyclerView.Adapter<ProductHolder> {

    List<Product> products;
    ViewGroup parent;

    final long ONE_MEGABYTE = 1024 * 1024;

    RVMenuAdapter(List<Product> products){
        this.products = products;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = parent;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        ProductHolder ph = new ProductHolder(v);
        return ph;
    }

    @Override
    public void onBindViewHolder(final ProductHolder holder, int position) {
        Product product = products.get(position);
        holder.productName.setText(product.getNombre());
        holder.vendorName.setText(product.getVendedor().getNombre());

        if(!product.getImagen().isEmpty()){
            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageReference = storage.getReferenceFromUrl("gs://m-eat-342e8.appspot.com").child(product.getImagen());

            storageReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    ByteArrayInputStream imageStream = new ByteArrayInputStream(bytes);
                    Bitmap bm = BitmapFactory.decodeStream(imageStream);
                    RoundedBitmapDrawable rid = RoundedBitmapDrawableFactory.create(parent.getContext().getResources(), bm);
                    rid.setCircular(true);
                    holder.productLogo.setImageDrawable(rid);
                }
            });

        }


    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
