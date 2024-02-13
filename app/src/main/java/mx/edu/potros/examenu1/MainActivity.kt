package mx.edu.potros.examenu1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


         lateinit var etCelsius: EditText
         lateinit var etFahrenheit: EditText

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        etCelsius = findViewById(R.id.etC)
        etFahrenheit = findViewById(R.id.etF)

        val btnToFahrenheit: Button = findViewById(R.id.btnF)
        val btnToCelsius: Button = findViewById(R.id.btnGC)

        btnToFahrenheit.setOnClickListener {
            convertTo("F")
        }

        btnToCelsius.setOnClickListener {
            convertTo("C")
        }
    }

    private fun convertTo(unit: String) {
        try {
            val entrada: Double
            val res: Double

            if (unit == "C") {
                entrada = etF.text.toString().toDouble()
                res = (entrada - 32) * 1.8
                etC.setText(String.format("%.2f", res))
            } else {
                entrada = etC.text.toString().toDouble()
                res = entrada * 1.8 + 32
                etF.setText(String.format("%.2f", res))
            }
        } catch (e: NumberFormatException) {
            if (unit == "C") {
                etC.setText("Ingrese un número válido")
            } else {
                etF.setText("Ingrese un número válido")
            }
        }
    }
}