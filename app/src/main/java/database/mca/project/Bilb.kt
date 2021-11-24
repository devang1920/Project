package database.mca.project



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Bilb : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bilb)

        var b1 = findViewById<Button>(R.id.button)
        b1.setOnClickListener {
            Toast.makeText(applicationContext,"Button is clicked",Toast.LENGTH_LONG).show()
        }

        var fb = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fb.setOnClickListener {
            Toast.makeText(applicationContext,"Floating action button is clicked",Toast.LENGTH_LONG).show()
        }

        var ib = findViewById<ImageButton>(R.id.imageButton)
        ib.setOnClickListener {
            Toast.makeText(applicationContext,"AU Logo is clicked",Toast.LENGTH_LONG).show()
        }


        var iv = findViewById<ImageView>(R.id.imageView)
        var tb = findViewById<ToggleButton>(R.id.toggleButton)
        tb.setOnClickListener{
            if(tb.text.toString().equals("ON")){
                iv.setImageResource(R.drawable.bulb_on)
            }else{
                iv.setImageResource(R.drawable.bulb_off)
            }
        }

        var sv = findViewById<Switch>(R.id.switch1)
        sv.text = "Bulb Off"
        sv.setOnClickListener {
            if(sv.text.toString().equals("Bulb Off")){
                sv.text = "Bulb On"
                iv.setImageResource(R.drawable.bulb_on)
            }else{
                sv.text = "Bulb Off"
                iv.setImageResource(R.drawable.bulb_off)
            }
        }

        var cb1 = findViewById<CheckBox>(R.id.checkBox)
        var cb2 = findViewById<CheckBox>(R.id.checkBox2)
        var cb3 = findViewById<CheckBox>(R.id.checkBox3)
        var tv = findViewById<TextView>(R.id.textView)

        cb1.setOnClickListener {
            var str = "Java is ${cb1.isChecked}\nKotlin is ${cb2.isChecked}\nSQL is ${cb3.isChecked}"
            tv.setText(str)
        }
        cb2.setOnClickListener {
            var str = "Java is ${cb1.isChecked}\nKotlin is ${cb2.isChecked}\nSQL is ${cb3.isChecked}"
            tv.setText(str)
        }
        cb3.setOnClickListener {
            var str = "Java is ${cb1.isChecked}\nKotlin is ${cb2.isChecked}\nSQL is ${cb3.isChecked}"
            tv.setText(str)
        }


        var tv2 = findViewById<TextView>(R.id.textView2)
        var rg = findViewById<RadioGroup>(R.id.radioGroup)
        rg.setOnCheckedChangeListener { radioGroup, i ->
            var rb = findViewById<RadioButton>(i)
            if(rb!=null)
                tv2.text = rb.text

        }

        var b2 = findViewById<Button>(R.id.button2)
        b2.setOnClickListener {
            rg.clearCheck()
            tv2.setText("Choose \nan Option")
        }

    }
}






















