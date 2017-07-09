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

public class RVFlagAdapter extends RecyclerView.Adapter<VendedoresHolder> {

    List<Vendedores> vendedores;
    ViewGroup parent;

    final long ONE_MEGABYTE = 1024 * 1024;

    RVFlagAdapter(List<Vendedores> vendedores){this.vendedores = vendedores;}

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public VendedoresHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = parent;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.flag_item,parent,false);
        VendedoresHolder vh = new VendedoresHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final VendedoresHolder holder, int position) {
        Vendedores vendedor = vendedores.get(position);
        holder.vendorName.setText(vendedor.getNombres());

        if(!vendedor.getImagen().isEmpty()){
            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageReference = storage.getReferenceFromUrl("gs://m-eat-342e8.appspot.com").child(vendedor.getImagen());

            storageReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    ByteArrayInputStream imageStream = new ByteArrayInputStream(bytes);
                    Bitmap bm = BitmapFactory.decodeStream(imageStream);
                    RoundedBitmapDrawable rid = RoundedBitmapDrawableFactory.create(parent.getContext().getResources(),bm);
                    rid.setCircular(true);
                    holder.flagLogo.setImageDrawable(rid);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
