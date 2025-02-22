package com.lucas.cadastro

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
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
                if (fullName.isBlank()) {
                    Toast.makeText(this@MainActivity, "O nome não pode ser vazio", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                val phone = inputPhone.text.toString()
                if (phone.isBlank()) {
                    Toast.makeText(this@MainActivity, "O telefone não pode ser vazio", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                val email = inputEmail.text.toString()
                if (email.isBlank()) {
                    Toast.makeText(this@MainActivity, "O email não pode ser vazio", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                val isOnEmailList = checkboxEmail.isChecked

                val gender = when (radioGroup.checkedRadioButtonId) {
                    radioButtonMasculino.id -> "Masculino"
                    radioButtonFeminino.id -> "Feminino"
                    else -> ""
                }
                if (gender == "" ) {
                    Toast.makeText(this@MainActivity, "O gênero não pode ser vazio", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                val city = inputCidade.text.toString()
                if (city.isBlank()) {
                    Toast.makeText(this@MainActivity, "A cidade não pode ser vazia", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                val uf = spinner.selectedItem.toString()

                val formulario = Formulario(fullName, phone, email, isOnEmailList, gender, city, uf)

                Toast.makeText(this@MainActivity, formulario.toString(), Toast.LENGTH_LONG).show()
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