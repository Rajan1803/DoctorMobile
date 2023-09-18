package com.example.doctormobile.helpers

object Utility {

    fun isValidPassword(password: String?): Boolean {
        if (password == null) {
            return false
        }
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
        val passwordMatcher = Regex(passwordPattern)
        return passwordMatcher.find(password) != null
    }

    fun isUsernameValid(email: String?): Boolean {
        return email?.isNotEmpty() ?: false
    }

    fun isEmailValid(email: String): Boolean {
        val emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        return email.matches(emailPattern.toRegex())
    }

}