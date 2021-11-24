package database.mca.project

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TableLayout
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class Calculator : AppCompatActivity() {
    lateinit var btn0 : Button
    lateinit var btn1 : Button
    lateinit var btn2 : Button
    lateinit var btn3 : Button
    lateinit var btn4 : Button
    lateinit var btn5 : Button
    lateinit var btn6 : Button
    lateinit var btn7 : Button
    lateinit var btn8 : Button
    lateinit var btn9 : Button
    lateinit var btnpoint : Button
    lateinit var edvalue : TextView
    lateinit var txtresult : TextView
    lateinit var btnplus : Button
    lateinit var btnminus : Button
    lateinit var btnmultiplay : Button
    lateinit var btndivide : Button
    lateinit var btnmodulo : Button
    lateinit var btnplusminus : Button
    lateinit var txtop : TextView
    var opsign = ""
    var OldValue = ""
    var isNewOp = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        edvalue = findViewById(R.id.edValue)
        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnpoint = findViewById(R.id.btnPoint)
        btnplus = findViewById(R.id.btnPlus)
        btnminus = findViewById(R.id.btnMinus)
        btnmultiplay = findViewById(R.id.btnMultiplay)
        btndivide = findViewById(R.id.btnDivide)
//        btnmodulo = findViewById(R.id.btnModulo)
        btnplusminus = findViewById(R.id.btnPlusMinus)
        txtop = findViewById(R.id.txtOp)
        txtresult = findViewById(R.id.txtResult)
    }

    fun numberEvent(view: View) {
        if(isNewOp)
            edvalue.setText("")
        isNewOp = false
        var btnselect = view as Button
        var value = edvalue.text.toString()
        when(btnselect.id){
            btn0.id -> {value += "0"}
            btn1.id -> {value += "1"}
            btn2.id -> {value += "2"}
            btn3.id -> {value += "3"}
            btn4.id -> {value += "4"}
            btn5.id -> {value += "5"}
            btn6.id -> {value += "6"}
            btn7.id -> {value += "7"}
            btn8.id -> {value += "8"}
            btn9.id -> {value += "9"}
            btnpoint.id -> {value += "."}
            btnplusminus.id -> { value =  "-$value"}
        }
        edvalue.setText(value)
    }

    fun OprationEvent(view: View) {
        var btnselect = view as Button
        OldValue = edvalue.text.toString()

        when(btnselect.id) {
            btnplus.id -> {
                opsign = "+"
            }
            btnminus.id -> {
                opsign = "-"
            }
            btnmultiplay.id -> {
                opsign = "*"
            }
            btndivide.id -> {
                opsign = "/"
            }
        }
        txtop.setText(opsign)
        isNewOp = true
    }

    fun EqualEvent(view: View) {
        var NewValue = edvalue.text.toString()
        var result = 0.0
        if(edvalue.text.toString() == "") {
            return edvalue.setText("")
        }
        else{
            when(opsign){
                "+" -> {result = OldValue.toDouble() + NewValue.toDouble()}
                "-" -> {result = OldValue.toDouble() - NewValue.toDouble()}
                "*" -> {result = OldValue.toDouble() * NewValue.toDouble()}
                "/" -> {result = OldValue.toDouble() / NewValue.toDouble()}
            }
            txtresult.setText("$OldValue $opsign $NewValue")
            edvalue.setText(result.toString())
        }
    }

    fun AcEvent(view: View) {
        edvalue.setText("0")
        txtop.setText("")
        txtresult.setText("")
        isNewOp = true
    }

    fun DeleteEvent(view: View) {
        edvalue.setText(edvalue.text.toString().dropLast(1))
    }
}

