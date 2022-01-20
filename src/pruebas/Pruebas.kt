package pruebas

import java.util.*
import kotlin.concurrent.thread

typealias myMap = MutableMap<String, List<String>>
typealias myFun = (Int, String, myMap) -> Boolean

fun main() {
    // when
    val variable = 5
    when (variable) {
        0, 5, 3 -> "Hola"
        in 8..15 -> "chao"
        else -> "xD"
    }

    // arrays
    val name = "Andres"
    val age = "23"
    val myArray = arrayListOf<String>()
    myArray.add(name)
    myArray.add(age)
    myArray.addAll(listOf("Fabian", "22"))

    // bucles
    for (x in 0..10) {
        // Tiene en cuenta el 10
    }
    for (x in 0 until 10) {
        // No tiene en cuenta el 10
    }
    for (x in 0..10 step 2) {
        // De dos en dos
    }
    for (x in 10 downTo 0) {
        // De diez a cero
    }

    // null safety
    val otherName: String? = "Hola" // Permite que una variable sea null
    println(otherName!!.length) // Obliga a que la variable no sea nula, de lo contrario mandaría un error
    println(otherName?.length) // Valida si es nula, en caso de ser nula imprime la variable sin ejecutar la función length

    otherName?.let {
        println(it) // Se ejecuta cuando la variable otherName no sea nula
    } ?: run {
        println(otherName) // En caso de ser nula se ejecuta este bloque
    }

    // Clases
    val andres = Programmer("Andrés", 23, listOf(Programmer.Languajes.JAVA, Programmer.Languajes.KOTLIN))
    println(andres.presentation())

    val array = Programmer.Languajes.values()
    println(array[0])

    // La clase anidada No puede acceder a las propiedades de la clase externa
    val number1 = NestedAndInnerClass.NestedClass().sumOne(10)
    println(number1)

    // La clase inner es una clase interna y puede acceder a las propiedades de la clase externa
    val number2 = NestedAndInnerClass().InnerClass().sumTwo(15)
    println(number2)

    // open class -> Permite que la clase pueda ser heredada
    // open fun -> Permite que los métodos puedan ser heredados

    // data class
    val juan = Worker("Juan", 22, "Programador")
    juan.lastWork = "Técnico"

    val sara = Worker()

    val juan2 = Worker("Juan", 22, "Programador")
    juan2.lastWork = "Técnico"

    // Los data class nos provee de métodos para manejo de datos como equals y hashCode
    if(juan == sara) println("Son iguales")
    else println("No son iguales") // Imprime No son iguales

    // Al ser data class No se valida el código de referencia del objeto sino los datos internos
    if(juan == juan2) println("Son iguales") // imprime Son iguales
    else println("No son iguales")

    // Cuando se imprime un objeto de una clase con toString se imprime el código de referencia
    // En el caso de una data class nos imprime las propiedades del objeto
    println(juan)

    // copy -> Permite clonar un objeto y modificar solo las propiedades que queramos
    val copiaJuan = juan.copy(work = "Programador Android")
    println(copiaJuan)

    // data class también permite desestructurar objetos, asignamos _ a las propiedades que no queramos desestructurar
    val (juanName, _, juanWork) = juan
    println("Nombre $juanName; Trabajo $juanWork")

    // typealias -> Permite crear alias para declaraciones o funciones
    val map: myMap = mutableMapOf()

    val function: myFun = {number, chain, mutableMap ->
        number != 0 && chain != "" && mutableMap.isNotEmpty()
    }

    val myMap = mapOf(1 to "Andres", 2 to "Fabian", 3 to "Rangel", 4 to "Mariño")
    for((id, names) in myMap){
        println("$id, $names")
    }

    // Probando funciones de extensión
    val myDate = Date()
    println(myDate.customFormat())
    println(myDate.size)

    // Probando funciones Lambda
    val sumFun = fun (x: Int, y: Int): Int = x + y
    val subtractionFun = fun (x: Int, y: Int): Int = x - y

    println(calculate(10, 5, sumFun))
    println(calculate(10, 5, subtractionFun))
    println(calculate(10, 5) { x, y -> x * y })

    asyncFun("Andrés"){
        println(it)
    }

}

fun calculate(x: Int, y: Int, myFun: (Int, Int) -> Int): Int{
    return myFun(x, y)
}

fun asyncFun(name: String, hello: (String) -> Unit){
    val message = "Hello $name!!"
    thread {
        Thread.sleep(5000)
        hello(message)
    }
    thread {
        Thread.sleep(10000)
        hello(message)
    }
    thread {
        Thread.sleep(15000)
        hello(message)
    }
}