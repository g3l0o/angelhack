package app.meat.com.m_eat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by EduardoYair on 08/07/2017.
 */

public class MapFragment extends Fragment implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {
    private AppCompatActivity mBaseActivity;
    private View mView;

    private GoogleMap iGoogleMap;
    private MapView iMapView;
    private LocationManager locationManager;
    private String provider;
    //private Location iLocation;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    LocationListener ll;

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(mBaseActivity)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.map_fragment, container, false);

        iMapView = (MapView) mView.findViewById(R.id.mapa);

        iMapView.onCreate(savedInstanceState);

        //get location


        iMapView.onResume();

        initializeMap(iMapView);




        return mView;
    }

    private void initializeMap(MapView mapView) {
        mapView.getMapAsync(this);


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBaseActivity = (AppCompatActivity) getActivity();
        ll = (LocationListener) this;
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

    @Override
    public void onLocationChanged(Location location)
    {
        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));//
        mCurrLocationMarker = iGoogleMap.addMarker(markerOptions);

        //move map camera
        iGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        iGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(11));

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient,ll);

        }
    }

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
        }if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(mBaseActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                iGoogleMap.setMyLocationEnabled(true);
            }
        }
        else {
            buildGoogleApiClient();
            iGoogleMap.setMyLocationEnabled(true);
        }

        ///////////


        // For dropping a marker at a point on the Map

        LatLng mexicana = new LatLng(19.411, -99.169121);
        LatLng francesa = new LatLng(19.422080, -99.169100);
        LatLng italiana = new LatLng(19.452020, -99.169200);
        LatLng japonesa = new LatLng(19.52100, -99.169130);

        iGoogleMap.addMarker(new MarkerOptions().position(mexicana).title("Mexicana").snippet("Comida mexicana ospiciada por martin").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_flag_mex)));
        iGoogleMap.addMarker(new MarkerOptions().position(italiana).title("Italiana").snippet("Comida mexicana ospiciada por Jair").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_flag_ita)));
        iGoogleMap.addMarker(new MarkerOptions().position(francesa).title("Francesa").snippet("Comida mexicana ospiciada por Carlos").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_flag_fra)));
        iGoogleMap.addMarker(new MarkerOptions().position(japonesa).title("Japonesa").snippet("Comida mexicana ospiciada por Hairu").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_flag_jap)));


        //get self location

        // For zooming automatically to the location of the marker
        //CameraPosition cameraPosition = new CameraPosition.Builder().target(myLocation).zoom(12).build();
        //iGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

    @Override
    public void onConnected(Bundle bundle) {

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(mBaseActivity,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest,this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}