package com.example.multilinetextwidget

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val viewBuildInfo = findViewById<TextView>(R.id.BuildInfo)

        val buildInfo = getString(
            R.string.build_info_template,
            Build.MANUFACTURER,
            Build.MODEL,
            Build.BRAND,
            Build.TYPE,
            Build.USER,
            Build.VERSION_CODES.BASE,
            Build.VERSION.INCREMENTAL,
            Build.VERSION.SDK_INT,
            Build.VERSION.RELEASE,
            Build.DISPLAY
        )

        viewBuildInfo.text = buildInfo

        //Anterior implementacao
        // val viewBuildInfo = findViewById<TextView>(R.id.BuildInfo)
        //
        //
        // val buildInfo = """
        //
        // Manufacturer: ${Build.MANUFACTURER}
        // Model: ${Build.MODEL}
        // Brand: ${Build.BRAND}
        // Type: ${Build.TYPE}
        // User: ${Build.USER}
        // Base: ${Build.VERSION_CODES.BASE}
        // Incremental: ${Build.VERSION.INCREMENTAL}
        // SDK: ${Build.VERSION.SDK_INT}
        // Version Code: ${Build.VERSION.RELEASE}
        // Display: ${Build.DISPLAY}
        // """.trimIndent()
        //
        // viewBuildInfo.text = buildInfo
    }
}