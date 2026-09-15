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
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.appvideo.ui.theme.AppVideoTheme

class MainActivity : ComponentActivity() {

    private lateinit var Playview: PlayerView
    private lateinit var player: Player
    private var isFsc = null;
    private var Isplaying: Boolean = false
    private var Speed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Playview = findViewById(R.id.viewPlayerView)

        var btnVideo1: Button = findViewById(R.id.btnVideo1)
        var btnVideo2: Button = findViewById(R.id.btnVideo2)
        var btnRepPa: Button = findViewById(R.id.btnRep)
        var btnFullsc: Button = findViewById(R.id.btnVideo1)
        var btnSpeed: Button = findViewById(R.id.btnSpeed)

        initPlay()

        btnVideo1.setOnClickListener {
           // SelectVideo(R.raw.video1)
        }
        btnVideo2.setOnClickListener {
            // SelectVideo(R.raw.video1)
        }

        btnRepPa.setOnClickListener {
            if (Isplaying) {
                player.pause()
                btnRepPa.text = "Reproduzir"
            } else {
                player.play()
                btnRepPa.text = "Pausar"
            }
        }
        btnSpeed.setOnClickListener {
            alterSpeed(btnSpeed)
        }
        btnFullsc.setOnClickListener {
            FullScreen()
        }
    }

    private fun initPlay() {
        player = ExoPlayer.Builder(this).build()
        Playview.player = player
        player.play()
    }
    private fun FullScreen() {
        // TODO...

    }

    private fun SelectVideo(video: Int) {
        // TODO...

    }
    private fun alterSpeed(btnSpeed: Button) {
        if (Speed) {
            player.setPlaybackSpeed(1.0f)
            Speed = false
            btnSpeed.text = "Velocidade: 2x"
        } else {
            player.setPlaybackSpeed(2.0f)
            Speed = true
            btnSpeed.text = "Velocidade: 1x"
        }
    }
}

