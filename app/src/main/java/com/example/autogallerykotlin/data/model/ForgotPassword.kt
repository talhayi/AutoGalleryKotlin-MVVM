package com.example.autogallerykotlin.data.model

data class ForgotPassword(

      val email: String? = null,
      val code: String? = null,
      val result: String? = null,
      val success: Boolean? = null
)

data class ResetPassword(
      val email: String? = null,
      val result: String? = null,
      val success: Boolean? = null,
      val password: String? = null

)

data class ResetPasswordCode(

      val result: String? = null,
      val success: Boolean? = null,
      val code: Boolean? = null
)