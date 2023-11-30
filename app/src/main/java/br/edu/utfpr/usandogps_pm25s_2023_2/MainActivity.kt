package br.edu.utfpr.usandogps_pm25s_2023_2

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity(), LocationListener {

    private lateinit var tvLatitude : TextView
    private lateinit var tvLongitude : TextView

    private lateinit var locationManager : LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvLatitude = findViewById( R.id.tvLatitude )
        tvLongitude = findViewById( R.id.tvLongitude )

        locationManager = getSystemService( Context.LOCATION_SERVICE ) as LocationManager

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }

        locationManager.requestLocationUpdates( LocationManager.NETWORK_PROVIDER, 0, 0f, this )

        ActivityCompat.requestPermissions( this, arrayOf( Manifest.permission.ACCESS_FINE_LOCATION ), 1 )

    }

    override fun onLocationChanged(position: Location) {
        tvLatitude.setText( position.latitude.toString() )
        tvLongitude.setText( position.longitude.toString() )
    }

    fun btVerMapaOnClick(view: View) {

    }
}