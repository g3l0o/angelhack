package app.meat.com.m_eat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by EduardoYair on 08/07/2017.
 */

public class menuFragmentScreen extends Fragment {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    private ArrayList<Product> products;

    private RecyclerView recyclerViewProducts;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        //Initialize Firebase
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("Productos");

        //initialize rv
        recyclerViewProducts = (RecyclerView) view.findViewById(R.id.rv_card_view_products);

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewProducts.setLayoutManager(llm);
        recyclerViewProducts.setHasFixedSize(true);

        getMenuData();

        super.onViewCreated(view, savedInstanceState);
    }

    public void getMenuData(){
        mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                products = new ArrayList<Product>();
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    final Product product = ds.getValue(Product.class);
                    products.add(product);
                }


                RVMenuAdapter adapter = new RVMenuAdapter(products);
                recyclerViewProducts.setAdapter(adapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
