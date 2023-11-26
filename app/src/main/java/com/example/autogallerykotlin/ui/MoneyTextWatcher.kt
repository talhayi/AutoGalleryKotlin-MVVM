package com.example.autogallerykotlin.ui

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import java.lang.ref.WeakReference
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.Locale
import java.util.Objects

class MoneyTextWatcher(editText: EditText) : TextWatcher {
    private val editTextWeakReference: WeakReference<EditText>

    init {
        editTextWeakReference = WeakReference(editText)
        formatter.maximumFractionDigits = 0
        formatter.roundingMode = RoundingMode.FLOOR
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    override fun afterTextChanged(s: Editable) {
        val editText = editTextWeakReference.get()
        if (editText == null || editText.text.toString().isEmpty()) {
            return
        }
        editText.removeTextChangedListener(this)
        val parsed: BigDecimal = parseCurrencyValue(editText.text.toString())
        val formatted: String = formatter.format(parsed)
        editText.setText(formatted)
        editText.setSelection(formatted.length)
        editText.addTextChangedListener(this)
    }

    companion object {
        private val locale = Locale("tr", "TR")
        private val formatter = DecimalFormat()

        fun parseCurrencyValue(value: String): BigDecimal {
            try {
                val replaceRegex = java.lang.String.format(
                    "[%s,.\\s]",
                    Objects.requireNonNull(formatter.currency).getSymbol(locale)
                )
                var currencyValue = value.replace(replaceRegex.toRegex(), "")
                currencyValue = if ("" == currencyValue) "0" else currencyValue
                return BigDecimal(currencyValue)
            } catch (e: Exception) {
                Log.e("App", e.message, e)
            }
            return BigDecimal.ZERO
        }
    }
}