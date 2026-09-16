package com.example.appvideo

import android.content.pm.ActivityInfo
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
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.FrameLayout
import android.widget.TextView
import androidx.compose.ui.tooling.preview.Preview
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.appvideo.ui.theme.AppVideoTheme

class MainActivity : ComponentActivity() {

    private lateinit var playerView: PlayerView
    private lateinit var player: Player
    private var isFsc = false;
    private var Isplaying: Boolean = false
    private var Speed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playerView = findViewById(R.id.viewPlayerView)

        var btnVideo1: Button = findViewById(R.id.btnVideo1)
        var btnVideo2: Button = findViewById(R.id.btnVideo2)
        var btnRepPa: Button = findViewById(R.id.btnRep)
        var btnFullsc: Button = findViewById(R.id.btnFullScreen)
        var btnSpeed: Button = findViewById(R.id.btnSpeed)

        initPlay()

        btnVideo1.setOnClickListener {
           SelectVideo(R.raw.video1)
        }
        btnVideo2.setOnClickListener {
            SelectVideo(R.raw.video2)
        }

        btnRepPa.setOnClickListener {
            if (player.isPlaying) {
                player.pause()
                btnRepPa.text = "Pausar"
            } else {
                player.play()
                btnRepPa.text = "Reproduzir"
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
        playerView.player = player
        SelectVideo(R.id.btnVideo1)
    }
    private fun FullScreen() {
        isFsc = !isFsc

        val playerContainer: FrameLayout =
            findViewById(R.id.playerContainer)

        val ctrlLyt: LinearLayout =
            findViewById(R.id.ctrlLyt)

        val titulo: TextView = findViewById(R.id.txtTitulo)
        val mainLyt: LinearLayout = findViewById(R.id.mainLayout)

        if (isFsc) {

            ctrlLyt.visibility = View.GONE
            titulo.visibility = View.GONE

            mainLyt.setPadding(0,0,0,0)
            window.insetsController?.hide(
                WindowInsets.Type.systemBars()
            )

            window.insetsController?.systemBarsBehavior =
                WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            playerContainer.layoutParams =
                playerContainer.layoutParams.apply {
                    width = ViewGroup.LayoutParams.MATCH_PARENT
                    height = ViewGroup.LayoutParams.MATCH_PARENT
                }

        } else {

            ctrlLyt.visibility = View.VISIBLE
            titulo.visibility = View.VISIBLE

            window.insetsController?.show(
                WindowInsets.Type.systemBars()
            )

            // Volta ao tamanho normal
            playerContainer.layoutParams =
                playerContainer.layoutParams.apply {
                    width = ViewGroup.LayoutParams.MATCH_PARENT
                    height = 220.dpToPx()
                }
        }
    }

    private fun SelectVideo(video: Int) {
        // TODO...
        val uri = Uri.parse("android.resource://$packageName/$video")
        val mediaItem = MediaItem.fromUri(uri)
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
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
    private fun Int.dpToPx(): Int {
        return (this * resources.displayMetrics.density).toInt()
    }
    override fun onStop() {
        super.onStop()
        player.pause()
    }
    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}

