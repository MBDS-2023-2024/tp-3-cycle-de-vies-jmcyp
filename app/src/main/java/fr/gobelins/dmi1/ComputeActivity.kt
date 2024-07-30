package fr.gobelins.dmi1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComputeActivity : AppCompatActivity() {

    private lateinit var btnCompute: Button
    private lateinit var firstOperand: EditText
    private lateinit var secondOperand: EditText
    private lateinit var resultTextView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)

        val operation = intent.getStringExtra("operation") ?: "ADD"

        firstOperand = findViewById(R.id.first_operand)
        secondOperand = findViewById(R.id.second_operand)
        btnCompute = findViewById(R.id.btn_compute)
        resultTextView = findViewById(R.id.result_text_view)

        btnCompute.setOnClickListener {
            val operand1 = firstOperand.text.toString().toDoubleOrNull()
            val operand2 = secondOperand.text.toString().toDoubleOrNull()

            if (operand1 != null && operand2 != null) {
                val result = when (operation) {
                    "ADD" -> operand1 + operand2
                    else -> 0.0
                }
                resultTextView.text = "Result: $result"
            } else {
                resultTextView.text = "Please enter valid numbers"
            }
          }
        }
    }
