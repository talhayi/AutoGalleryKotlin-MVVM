package com.example.autogallerykotlin.model

import android.provider.ContactsContract
import android.text.TextUtils
import android.util.Patterns

data class Login(
    val id: Int? = null,
    val email: String? = null,
    val password: String? = null
)

/*{
    fun isValidEmail(): Boolean{

        if(this.email != null && !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return true
        }
        return false
    }

    fun isValidPassword(): Boolean{

        if(this.password != null && this.password.length >=6){
            return true
        }
        return false
    }

}
*/


