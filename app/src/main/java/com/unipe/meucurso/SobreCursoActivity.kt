package com.unipe.meucurso

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * Tela 2 - Sobre o Curso
 * Mostra detalhes do curso (duração, modalidade, descrição) e
 * permite voltar para a Home ou seguir para Disciplinas.
 */
class SobreCursoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre_curso)

        val btnVoltar = findViewById<Button>(R.id.btnVoltarHome)
        val btnDisciplinas = findViewById<Button>(R.id.btnIrDisciplinas)

        // finish() encerra esta Activity e retorna para a tela anterior (Home),
        // que continua na pilha (back stack) e não precisa ser recriada.
        btnVoltar.setOnClickListener {
            finish()
        }

        btnDisciplinas.setOnClickListener {
            val intent = Intent(this, DisciplinasActivity::class.java)
            startActivity(intent)
        }
    }
}
