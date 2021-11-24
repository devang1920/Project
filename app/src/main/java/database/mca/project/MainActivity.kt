package database.mca.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button
    lateinit var button10: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)

        button.setOnClickListener {
            var intent = Intent(applicationContext, Calculator::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            var intent = Intent(applicationContext, TikTack::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener {
            var intent = Intent(applicationContext, ShivMantra::class.java)
            startActivity(intent)
        }

        button4.setOnClickListener {
            var intent = Intent(applicationContext, Bilb::class.java)
            startActivity(intent)
        }

        button5.setOnClickListener {
            var intent = Intent(applicationContext, Read_Contact_2::class.java)
            startActivity(intent)
        }

        button6.setOnClickListener {
            var intent = Intent(applicationContext, Contact_Provider::class.java)
            startActivity(intent)
        }

    }


}