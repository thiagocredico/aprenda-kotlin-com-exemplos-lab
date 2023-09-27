enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(
    val nome: String,
    val email: String,
    val idade: Int
)

data class ConteudoEducacional(
    val nome: String,
    val duracao: Int = 60,
    val descricao: String,
    val autor: String
)

class Formacao(
    val nome: String,
    val nivel: Nivel,
    var conteudos: MutableList<ConteudoEducacional> = mutableListOf()
) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo '${conteudo.nome}' adicionado à formação $nome.")
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        conteudos.remove(conteudo)
        println("Conteúdo '${conteudo.nome}' removido da formação $nome.")
    }

    fun exibirDetalhes() {
        println("Formação: $nome")
        println("Nível: $nivel")
        println("Conteúdos:")
        for (conteudo in conteudos) {
            println(" - ${conteudo.nome} (${conteudo.duracao} minutos) - ${conteudo.descricao} (por ${conteudo.autor})")
        }
        println("Inscritos:")
        for (inscrito in inscritos) {
            println(" - ${inscrito.nome} (${inscrito.email})")
        }
    }
}

fun main() {
    // Criando alguns usuários e conteúdos educacionais de exemplo
    val usuario1 = Usuario("João", "joao@example.com", 25)
    val usuario2 = Usuario("Maria", "maria@example.com", 30)

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90, "Conceitos básicos de Kotlin", "Professor A")
    val conteudo2 = ConteudoEducacional("Kotlin Avançado", 120, "Tópicos avançados de Kotlin", "Professor B")

    // Criando uma formação e adicionando conteúdos
    val formacaoKotlin = Formacao("Formação Kotlin", Nivel.INTERMEDIARIO)
    formacaoKotlin.adicionarConteudo(conteudo1)
    formacaoKotlin.adicionarConteudo(conteudo2)

    // Matriculando usuários na formação
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    // Exibindo detalhes da formação
    formacaoKotlin.exibirDetalhes()
}
