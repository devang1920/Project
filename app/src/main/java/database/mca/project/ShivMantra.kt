package database.mca.project

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ShivMantra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shiv_mantra)

        var res = resources.getIdentifier("shivmahimna","raw",packageName)
        var mp = MediaPlayer.create(applicationContext, res)

        var b1 = findViewById<Button>(R.id.button)
        b1.setOnClickListener {
            mp.start()
        }

        var b2 = findViewById<Button>(R.id.button2)
        b2.setOnClickListener {
            mp.pause()
        }
    }
}