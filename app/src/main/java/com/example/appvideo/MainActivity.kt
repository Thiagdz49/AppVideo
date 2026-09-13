package com.example.appvideo

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.VideoView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appvideo.ui.theme.AppVideoTheme

class MainActivity : ComponentActivity() {

    private lateinit var view: VideoView
    private lateinit var ctrlLayout: LinearLayout
    private var isFsc = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view = findViewById(R.id.viewVideo)
        ctrlLayout = findViewById(R.id.ctrlLyt)

        var btnVideo1: Button = findViewById(R.id.btnVideo1)
        var btnVideo2: Button = findViewById(R.id.btnVideo2)
        var btnRepPa: Button = findViewById(R.id.btnRep)
        var btnFullsc: Button = findViewById(R.id.btnVideo1)

        initVideo()


    }

    private fun initVideo() {
        // TODO...
    }
}

