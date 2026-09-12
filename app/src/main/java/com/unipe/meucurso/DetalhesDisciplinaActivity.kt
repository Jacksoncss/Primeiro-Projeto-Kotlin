package com.unipe.meucurso

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Tela 4 - Detalhes da Disciplina
 *
 * Esta é uma ÚNICA Activity reaproveitada para todas as disciplinas do curso.
 * Ela não conhece de antemão qual disciplina será exibida: os dados chegam
 * através dos "extras" do Intent que a chamou (enviado pela DisciplinasActivity),
 * e é essa informação que decide o que aparece na tela.
 */
class DetalhesDisciplinaActivity : AppCompatActivity() {

    // Chaves usadas para colocar/recuperar os dados dentro do Intent.
    // Ficam centralizadas aqui para evitar erros de digitação nas duas pontas.
    companion object {
        const val EXTRA_NOME = "extra_nome_disciplina"
        const val EXTRA_CARGA_HORARIA = "extra_carga_horaria"
        const val EXTRA_MODALIDADE = "extra_modalidade"
        const val EXTRA_NIVEL = "extra_nivel"
        const val EXTRA_PREREQUISITO = "extra_prerequisito"
        const val EXTRA_DESCRICAO = "extra_descricao"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_disciplina)

        // 1) RECEBENDO A INFORMAÇÃO: lemos os extras do Intent que abriu esta Activity.
        //    intent.getStringExtra() busca o valor associado a cada chave.
        //    Se por algum motivo o extra não vier preenchido, usamos um texto padrão.
        val nome = intent.getStringExtra(EXTRA_NOME) ?: "Disciplina"
        val cargaHoraria = intent.getStringExtra(EXTRA_CARGA_HORARIA) ?: "-"
        val modalidade = intent.getStringExtra(EXTRA_MODALIDADE) ?: "-"
        val nivel = intent.getStringExtra(EXTRA_NIVEL) ?: "-"
        val preRequisito = intent.getStringExtra(EXTRA_PREREQUISITO) ?: "-"
        val descricao = intent.getStringExtra(EXTRA_DESCRICAO) ?: ""

        // 2) Localizamos as views do layout.
        val txtNome = findViewById<TextView>(R.id.txtNomeDisciplina)
        val txtCarga = findViewById<TextView>(R.id.txtCargaHoraria)
        val txtModalidade = findViewById<TextView>(R.id.txtModalidadeDisciplina)
        val txtNivel = findViewById<TextView>(R.id.txtNivel)
        val txtPreRequisito = findViewById<TextView>(R.id.txtPreRequisito)
        val txtDescricao = findViewById<TextView>(R.id.txtDescricaoDisciplina)

        val btnVoltarTopo = findViewById<ImageButton>(R.id.btnVoltarDetalhes)
        val btnVoltar = findViewById<Button>(R.id.btnVoltarParaDisciplinas)
        val btnCompartilhar = findViewById<Button>(R.id.btnCompartilharDisciplina)

        // 3) Preenchemos a tela com os dados recebidos.
        txtNome.text = nome
        txtCarga.text = cargaHoraria
        txtModalidade.text = modalidade
        txtNivel.text = nivel
        txtPreRequisito.text = preRequisito
        txtDescricao.text = descricao

        // 4) Botão Voltar (tanto o do topo quanto o do rodapé): finish() encerra
        //    esta Activity e retorna para a DisciplinasActivity, que continua
        //    viva na pilha de telas (back stack).
        btnVoltarTopo.setOnClickListener { finish() }
        btnVoltar.setOnClickListener { finish() }

        // 5) DESAFIO FINAL - funcionalidade própria: botão "Compartilhar".
        //    Cria um Intent implícito (ACTION_SEND) para que o usuário escolha,
        //    entre os apps instalados no aparelho, com quem quer compartilhar
        //    as informações da disciplina selecionada.
        btnCompartilhar.setOnClickListener {
            val textoCompartilhado = buildString {
                append("Disciplina: ").append(nome).append("\n")
                append("Carga horária: ").append(cargaHoraria).append("\n")
                append("Modalidade: ").append(modalidade).append("\n")
                append("Nível: ").append(nivel).append("\n")
                append("Pré-requisito: ").append(preRequisito).append("\n\n")
                append(descricao)
            }

            val intentCompartilhar = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "Disciplina: $nome")
                putExtra(Intent.EXTRA_TEXT, textoCompartilhado)
            }

            // Intent.createChooser abre a janela "Compartilhar via..." do Android
            startActivity(Intent.createChooser(intentCompartilhar, "Compartilhar disciplina"))
        }
    }
}
