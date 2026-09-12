package com.unipe.meucurso

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

/**
 * Tela 3 - Disciplinas
 * Lista as disciplinas do curso. Ao tocar em uma disciplina, o app cria um
 * Intent, envia os dados dessa disciplina como extras e abre a tela única
 * de detalhes (DetalhesDisciplinaActivity). O botão de voltar sempre retorna
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

        // Cada card de disciplina recebe o mesmo tratamento: ao ser clicado,
        // chama abrirDetalhes() passando os dados específicos daquela disciplina.
        findViewById<MaterialCardView>(R.id.cardProgramacao).setOnClickListener {
            abrirDetalhes(
                nome = getString(R.string.disc_programacao),
                carga = getString(R.string.carga_programacao),
                modalidade = getString(R.string.modalidade_programacao),
                nivel = getString(R.string.nivel_programacao),
                preRequisito = getString(R.string.prereq_programacao),
                descricao = getString(R.string.descricao_programacao)
            )
        }

        findViewById<MaterialCardView>(R.id.cardBd).setOnClickListener {
            abrirDetalhes(
                nome = getString(R.string.disc_bd),
                carga = getString(R.string.carga_bd),
                modalidade = getString(R.string.modalidade_bd),
                nivel = getString(R.string.nivel_bd),
                preRequisito = getString(R.string.prereq_bd),
                descricao = getString(R.string.descricao_bd)
            )
        }

        findViewById<MaterialCardView>(R.id.cardEngSoft).setOnClickListener {
            abrirDetalhes(
                nome = getString(R.string.disc_engsoft),
                carga = getString(R.string.carga_engsoft),
                modalidade = getString(R.string.modalidade_engsoft),
                nivel = getString(R.string.nivel_engsoft),
                preRequisito = getString(R.string.prereq_engsoft),
                descricao = getString(R.string.descricao_engsoft)
            )
        }

        findViewById<MaterialCardView>(R.id.cardWeb).setOnClickListener {
            abrirDetalhes(
                nome = getString(R.string.disc_web),
                carga = getString(R.string.carga_web),
                modalidade = getString(R.string.modalidade_web),
                nivel = getString(R.string.nivel_web),
                preRequisito = getString(R.string.prereq_web),
                descricao = getString(R.string.descricao_web)
            )
        }

        findViewById<MaterialCardView>(R.id.cardMobile).setOnClickListener {
            abrirDetalhes(
                nome = getString(R.string.disc_mobile),
                carga = getString(R.string.carga_mobile),
                modalidade = getString(R.string.modalidade_mobile),
                nivel = getString(R.string.nivel_mobile),
                preRequisito = getString(R.string.prereq_mobile),
                descricao = getString(R.string.descricao_mobile)
            )
        }

        findViewById<MaterialCardView>(R.id.cardIa).setOnClickListener {
            abrirDetalhes(
                nome = getString(R.string.disc_ia),
                carga = getString(R.string.carga_ia),
                modalidade = getString(R.string.modalidade_ia),
                nivel = getString(R.string.nivel_ia),
                preRequisito = getString(R.string.prereq_ia),
                descricao = getString(R.string.descricao_ia)
            )
        }
    }

    /**
     * Cria o Intent explícito para DetalhesDisciplinaActivity, anexa os dados
     * da disciplina selecionada como extras (putExtra) e inicia a nova tela.
     * Como é sempre a mesma Activity, apenas o conteúdo dos extras muda.
     */
    private fun Context.abrirDetalhes(
        nome: String,
        carga: String,
        modalidade: String,
        nivel: String,
        preRequisito: String,
        descricao: String
    ) {
        val intent = Intent(this, DetalhesDisciplinaActivity::class.java).apply {
            putExtra(DetalhesDisciplinaActivity.EXTRA_NOME, nome)
            putExtra(DetalhesDisciplinaActivity.EXTRA_CARGA_HORARIA, carga)
            putExtra(DetalhesDisciplinaActivity.EXTRA_MODALIDADE, modalidade)
            putExtra(DetalhesDisciplinaActivity.EXTRA_NIVEL, nivel)
            putExtra(DetalhesDisciplinaActivity.EXTRA_PREREQUISITO, preRequisito)
            putExtra(DetalhesDisciplinaActivity.EXTRA_DESCRICAO, descricao)
        }
        startActivity(intent)
    }
}
