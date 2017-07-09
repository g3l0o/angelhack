package app.meat.com.m_eat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by EduardoYair on 08/07/2017.
 */

public class MapFragment extends Fragment {
    private AppCompatActivity mBaseActivity;
    private View mView;

    private GoogleMap iGoogleMap;
    private MapView iMapView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBaseActivity = (AppCompatActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.map_fragment, container, false);

        iMapView = (MapView) mView.findViewById(R.id.mapa);

        iMapView.onCreate(savedInstanceState);

        iMapView.onResume();

        initializeMap(iMapView);



        return mView;
    }

    private void initializeMap(MapView mapView) {
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                iGoogleMap = mMap;

                // For showing a move to my location button
                if (ActivityCompat.checkSelfPermission(mBaseActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mBaseActivity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                iGoogleMap.setMyLocationEnabled(true);

                // For dropping a marker at a point on the Map
                LatLng mexicana = new LatLng(19.412040, -99.169121);
                iGoogleMap.addMarker(new MarkerOptions().position(mexicana).title("Mexicana").snippet("Comida mexicana ospiciada por martin").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_menu_camera)));

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(mexicana).zoom(12).build();
                iGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });



    }



    @Override
    public void onResume() {
        super.onResume();
        iMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        iMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        iMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        iMapView.onLowMemory();
    }

}