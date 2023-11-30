package br.edu.utfpr.usandogps_pm25s_2023_2

import android.content.Context
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvLatitude : TextView
    private lateinit var tvLongitude : TextView

    private lateinit var locationManager : LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvLatitude = findViewById( R.id.tvLatitude )
        tvLongitude = findViewById( R.id.tvLongitude )

        locationManager = getSystemService( Context.LOCATION_SERVICE ) as LocationManager


    }
}