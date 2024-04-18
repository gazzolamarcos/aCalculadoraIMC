package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

        val classificacao: String = if (result <= 18.5f) {
            tvClassificacao.setTextColor(getColor(R.color.magreza))
            "MAGREZA"
        } else if (result > 18.5f && result <= 24.9f) {
            tvClassificacao.setTextColor(getColor(R.color.normal))
            "NORMAL"
        } else if (result > 25f && result <= 29.9f) {
            tvClassificacao.setTextColor(getColor(R.color.sobrepeso))
            "SOBREPESO"
        } else if (result > 30f && result <= 39.9f) {
            tvClassificacao.setTextColor(getColor(R.color.obesidade))
            "OBESIDADE"
        } else {
            tvClassificacao.setTextColor(getColor(R.color.obesidade_grave))
            "OBESIDADE GRAVE"
        }

        tvClassificacao.text = classificacao
    }
}
