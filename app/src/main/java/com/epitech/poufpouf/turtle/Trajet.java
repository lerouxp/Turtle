package com.epitech.poufpouf.turtle;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Trajet extends FragmentActivity
{
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_trajet, menu);
        return true;
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded()
    {
        if (mMap == null)
        {
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            final String editDepart = getIntent().getStringExtra("DEPART");
            final String editArrivee = getIntent().getStringExtra("ARRIVEE");
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(47.322047, 5.041479999999979))
                    .title("Musée des Beaux-Arts de Dijon"));

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(47.322047, 5.041479999999979))
                    .title("Parc Naturel Régional du Morvan"));

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(47.275887, 4.099798999999962))
                    .title("Parc Naturel Régional du Morvan"));

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(47.795924, 3.5699710000000096))
                    .title("AJA Auxerre Marathon Athlétisme Club de course à pied"));
            new ItineraireTask(this, mMap, editDepart, editArrivee).execute();
            if (mMap != null)
            {
                setUpMap();
            }
        }
    }

    private void setUpMap()
    {
        //mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }

}