package app.meat.com.m_eat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Rogelio Rivera on 7/9/2017.
 */

public class RVMenuAdapter extends RecyclerView.Adapter<ProductHolder> {

    List<Product> products;
    ViewGroup parent;

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
    public void onBindViewHolder(ProductHolder holder, int position) {
        Product product = products.get(position);
        holder.productName.setText(product.getNombre());
        holder.vendorName.setText(product.getVendedor().getNombre());


    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
