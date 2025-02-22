package com.lucas.cadastro.model

class Formulario (
    val fullName: String,
    val phone: String,
    val email: String,
    val isOnEmailList: Boolean,
    val gender: String,
    val city: String,
    val uf: String
) {
    override fun toString(): String {
        return "Name: $fullName | phone: $phone | email: $email" +
                " | is on email list: $isOnEmailList | gender: $gender" +
                " | city: $city | uf: $uf"
    }
}