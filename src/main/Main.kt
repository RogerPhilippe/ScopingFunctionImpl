package main

fun main() {

    val personLateInit: Person? = null
    val attributes = Pair("Tony Stark", 30)

    // Retorna qualquer valor a partir de um objeto do qual o escopo se originou e refere-se a esse objeto como it.
    val personLet: Person = attributes.let {
        Person("${it.first} - let", it.second)
    }

    println(personLet)

    // Retorna qualquer valor a partir de um objeto do qual o escopo se originou e refere-se a esse objeto como this.
    val personRun: Person = attributes.run {
        Person("${this.first} - run", this.second)
    }

    println(personRun)

    // Retorna qualquer valor a partir de um objeto do qual o escopo se originou e refere-se a esse objeto como this.
    val personWith: Person = with(attributes) {
        Person("${this.first} - with", this.second)
    }

    println(personWith)

    println("********** Teste de modificação **********")

    // Modifica o objeto de escopo - Objeto como it.
    val personModByLet = Person("Tony Stark", 30)
    personModByLet.let {
        it.profession = "Iron Man - let"
        it.nickname = "Tony"
    }

    personModByLet.printObj()

    // Modifica o objeto de escopo - Objeto como this, pode ser omitido.
    val personModByRun = Person("Tony Stack", 30)
    personModByRun.run {
        this.profession = "Iron Man - run"
        this.nickname = "Tony"
    }

    println(personModByRun)

    // Modifica o objeto de escopo - Objeto como it.
    val personModByWith = Person("Tony Stack", 30)
    with(personModByWith) {
        this.profession = "Tpny Stack - with"
        this.nickname = ""
    }

    println(personModByWith)

    // Retorna o próprio objeto (modificado) do qual partiu o escopo e dentro desse escopo o objeto é referido como this.
    val personApply = Person("Tony Stark", 30)
    personApply.apply {
        this.profession = "Iron Man - apply"
        this.nickname = "Tony"
    }.printObj()

    // Retorna o próprio objeto (modificado) do qual partiu o escopo e dentro desse escopo o objeto é referido como it.
    val personAlso = Person("Tony Stark", 30)
    personAlso.also {
        it.profession = "Iron Man - also"
        it.nickname = "Tony"
    }.printObj()

    println("Validação Nullables")

    personLateInit?.let {
        val person = Person("${it.name} - Nullable let", it.age)
        println(person)
    }

    personLateInit?.run {
        val person = Person("$name - Nullable run", age)
        println(person)
    }

    /**
     * “This” externo e “this” do escopo, como usar?
     * Nas Scoping Functions que fazem uso do this como o apply, run e with,
     * caso precise recuperar o this externo ao escopo do bloco basta informar de
     * qual escopo ele pertence usando o this@ .
     */

}

data class Person(
    val name: String,
    val age: Int,
    var profession: String? = null,
    var nickname: String? = null
) {
    fun printObj() = println(this)
}