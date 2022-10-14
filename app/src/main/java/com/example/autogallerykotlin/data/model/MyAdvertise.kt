package com.example.autogallerykotlin.data.model

data class MyAdvertise(
	val myAdvertise: List<MyAdvertiseItem?>? = null
)

data class MyAdvertiseItem(
	val result: String? = null,
	val image: String? = null,
	val user_id: String? = null,
	val advert_title: String? = null,
	val price: String? = null,
	val address: String? = null,
	val success: Boolean? = null,
	val count: Int? = null,
	val explanation: String? = null,
	val advert_id: String? = null
)

