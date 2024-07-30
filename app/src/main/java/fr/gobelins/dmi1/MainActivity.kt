package fr.gobelins.dmi1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnHomeCompute: Button
    private lateinit var btnSos: Button
    private lateinit var btnSearch: Button
    private lateinit var btnShare: Button
    private lateinit var btnItineraire: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHomeCompute = findViewById(R.id.btn_home_compute)
        btnHomeCompute.setOnClickListener {
            val intent = Intent(this, ComputeActivity::class.java)
//            intent.extras?.putString("operation", "ADD")
            startActivity(intent)
        }

        btnSos = findViewById(R.id.btn_sos)
        btnSos.setOnClickListener{
            val sosNumber = "112"
            val callIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$sosNumber")
            }
            startActivity(callIntent)
        }

        btnSearch = findViewById(R.id.btn_search)
        btnSearch.setOnClickListener{
            val searchIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://google.fr")
            }
            startActivity(searchIntent)
        }

        btnShare = findViewById(R.id.btn_share)
        btnShare.setOnClickListener{
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Contenu partagé avec MBDS-HAITI.")
                type = "text/plain"
            }
            val chooser = Intent.createChooser(shareIntent, "Partager via")
            startActivity(chooser)
        }

        btnItineraire = findViewById(R.id.btn_itineraire)
        btnItineraire.setOnClickListener{
            val directionsIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=48.831201,2.356403")
            }
            startActivity(directionsIntent)
        }
    }
}