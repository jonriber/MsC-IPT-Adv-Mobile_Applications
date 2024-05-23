package pt.ipt.dama2024.openstreetmaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint

class MainActivity : AppCompatActivity() {

    private lateinit var mapView: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize osmdroid configuration
        // import org.osmdroid.config.Configuration
        Configuration.getInstance()
            .load(this, applicationContext.getSharedPreferences("osmdroid", MODE_PRIVATE))

        // Find the MapView and set its properties
        mapView = findViewById(R.id.mapView)
        mapView.setMultiTouchControls(true)
        mapView.controller.setZoom(15.0)
        val startPoint = GeoPoint(48.8583, 2.2944) // Coordinates for the Eiffel Tower
        mapView.controller.setCenter(startPoint)


        // Add a marker to the map
        val marker = Marker(mapView)
        marker.position = startPoint
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker.title = "Eiffel Tower"
        mapView.overlays.add(marker)

        Log.d("MainActivity", "Map initialized and centered on the Eiffel Tower")

    }


    override fun onResume() {
        super.onResume()
        mapView.onResume() // needed for compass, my location overlays, v6.0.0 and up
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause() // needed for compass, my location overlays, v6.0.0 and up
    }
}