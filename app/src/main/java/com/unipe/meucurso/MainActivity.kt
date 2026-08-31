package com.unipe.meucurso

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * Tela 1 - Home
 * Apresenta a instituição e o curso, com botões para navegar
 * até "Sobre o Curso" e "Disciplinas".
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnConheca = findViewById<Button>(R.id.btnConhecaCurso)
        val btnDisciplinas = findViewById<Button>(R.id.btnDisciplinas)

        // Ao clicar, cria um Intent explícito para abrir a tela SobreCursoActivity
        btnConheca.setOnClickListener {
            val intent = Intent(this, SobreCursoActivity::class.java)
            startActivity(intent)
        }

        // Ao clicar, cria um Intent explícito para abrir a tela DisciplinasActivity
        btnDisciplinas.setOnClickListener {
            val intent = Intent(this, DisciplinasActivity::class.java)
            startActivity(intent)
        }
    }
}
