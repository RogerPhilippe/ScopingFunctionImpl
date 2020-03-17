package main

fun main() {

    // Detalhes avançados sobre kotlin

    // while e do whle é igual do Java

    // For
    for (i in 1..10){
        if (i%2 != 0) print(i)
    }

    for (i in 1..10 step 2){
        if (i%2 != 0) print(i )
    }


    // Nullable
    val nome: String? = null
    nome?.toUpperCase()

    // Colecções
    // Arrays
    val array = arrayOf(1, 2, 3)
    // ArrayList
    val arrayList = arrayListOf(1, 2, 3)
    // List
    val lista = listOf(1, 2, 3)
    // HashMaps
    val mapas = mapOf("um" to 1, "dois" to 2, "tres" to 3)

    // List "mudável"
    val listaDois = mutableListOf(1, 2, 3)

    // Iteração em coleções
    val listaTres = mutableListOf(1, 2, 3)
    for (elemento in lista){
        print("$elemento")
    }

    // Usando iteração interna:
    listaTres.forEach { elemento -> print("$elemento") }

    // Extension function
    fun Int.multiplicado(valor: Int) = this * valor
    print(2.multiplicado(2))

    // Infix
    infix fun Int.multiplicadoInfix(valor: Int) = this * valor
    print(2 multiplicadoInfix 2)

}