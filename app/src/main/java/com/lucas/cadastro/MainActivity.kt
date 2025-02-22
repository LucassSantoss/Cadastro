package com.lucas.cadastro

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lucas.cadastro.databinding.ActivityMainBinding
import com.lucas.cadastro.model.Formulario

class MainActivity : AppCompatActivity() {
    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        with(activityMainBinding) {
            buttonSalvar.setOnClickListener {
                val fullName = inputName.text.toString()
                val phone = inputPhone.text.toString()
                val email = inputEmail.text.toString()
                val isOnEmailList = checkboxEmail.isChecked
                val gender = when (radioGroup.checkedRadioButtonId) {
                    radioButtonMasculino.id -> "Masculino"
                    radioButtonFeminino.id -> "Feminino"
                    else -> ""
                }
                val city = inputCidade.text.toString()
                val uf = spinner.selectedItem.toString()
                val formulario = Formulario(fullName, phone, email, isOnEmailList, gender, city, uf)

                println(formulario)
            }

            buttonLimpar.setOnClickListener {
                inputName.editableText.clear()
                inputPhone.editableText.clear()
                inputEmail.editableText.clear()
                checkboxEmail.isChecked = false
                radioButtonFeminino.isChecked = false
                radioButtonMasculino.isChecked = false
                inputCidade.editableText.clear()
            }
        }
    }
}