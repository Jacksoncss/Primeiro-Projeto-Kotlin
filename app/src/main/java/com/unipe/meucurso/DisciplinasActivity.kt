package com.unipe.meucurso

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

/**
 * Tela 3 - Disciplinas
 * Lista as disciplinas do curso. O botão de voltar sempre retorna
 * para a tela de onde o usuário veio (Home ou Sobre o Curso).
 */
class DisciplinasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disciplinas)

        val btnVoltar = findViewById<ImageButton>(R.id.btnVoltarDisciplinas)
        btnVoltar.setOnClickListener {
            finish()
        }
    }
}
