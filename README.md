# Meu Curso — UNIPE / Análise e Desenvolvimento de Sistemas

App Android (Kotlin) desenvolvido para o exercício da Aula 5 — Kotlin e Android Studio.

## Como abrir

1. Abra o **Android Studio**.
2. `File > Open` e selecione a pasta `MeuCurso` (a pasta que contém `settings.gradle.kts`).
3. Aguarde o **Gradle Sync** (o Android Studio baixa o wrapper do Gradle automaticamente).
4. Rode em um emulador ou dispositivo físico (▶️ Run).

## Estrutura do projeto

```
MeuCurso/
├── app/src/main/
│   ├── AndroidManifest.xml        → declara as 3 telas (activities)
│   ├── java/com/unipe/meucurso/
│   │   ├── MainActivity.kt        → Tela 1: Home
│   │   ├── SobreCursoActivity.kt  → Tela 2: Sobre o Curso
│   │   └── DisciplinasActivity.kt → Tela 3: Disciplinas
│   └── res/
│       ├── layout/                → os 3 arquivos XML das telas
│       ├── drawable/               → logo_unipe, img_curso (imagens),
│       │                            ic_voltar, ic_disciplina (ícones)
│       └── values/                 → strings.xml, colors.xml, themes.xml
```

## Navegação implementada

- **Home → Sobre o Curso**: `Intent(this, SobreCursoActivity::class.java)` + `startActivity()`
- **Home → Disciplinas**: `Intent(this, DisciplinasActivity::class.java)` + `startActivity()`
- **Sobre o Curso → Disciplinas**: mesmo padrão de Intent
- **Voltar** (em Sobre o Curso e Disciplinas): `finish()`, que fecha a tela atual e
  retorna à anterior na pilha de activities (back stack), sem precisar recriá-la.

## Por que os layouts são diferentes

- **Home**: `LinearLayout` vertical simples, tudo centralizado.
- **Sobre o Curso**: `ConstraintLayout` com banner de imagem fixo no topo, conteúdo
  rolável no meio e uma barra de botões fixa na parte inferior.
- **Disciplinas**: cabeçalho colorido + grade 2×3 de `MaterialCardView`.

## Sobre as imagens

As duas imagens (`logo_unipe.xml` e `img_curso.xml`) foram criadas como **vector
drawables** combinados em `layer-list` (forma + ícone), o que evita depender de
arquivos de imagem externos e mantém o app leve. Se preferir, você pode substituí-las
por fotos reais: basta colocar os arquivos `.png`/`.jpg` em `res/drawable` e trocar
a referência `android:src="@drawable/..."` nos layouts.

## Guia rápido para a apresentação (perguntas do professor)

- **O que esse código faz?** — veja os comentários em cada `.kt` e a seção
  "Navegação implementada" acima.
- **Por que você utilizou Intent?** — Intent é o mecanismo do Android para pedir a
  outro componente (aqui, outra Activity) que seja iniciado, opcionalmente passando dados.
- **Qual é a função do `startActivity()`?** — inicia a Activity indicada pelo Intent,
  empilhando-a sobre a atual.
- **Como o botão sabe qual ação deve executar?** — cada botão tem um
  `setOnClickListener { ... }` associado no `onCreate()` da Activity.
- **Onde está localizada a imagem utilizada?** — em `res/drawable/`, referenciada nos
  layouts por `@drawable/nome_do_arquivo`.
- **Qual arquivo XML representa esta tela?** — `activity_main.xml`,
  `activity_sobre_curso.xml` e `activity_disciplinas.xml`, um para cada tela.
- **O que aconteceria se você removesse o `finish()`?** — a tela anterior continuaria
  empilhada, mas o botão "voltar" da tela deixaria de fechar a tela atual (o botão
  físico/gesto de voltar do Android ainda funcionaria, pois é controlado pelo sistema).
