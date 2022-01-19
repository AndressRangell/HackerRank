package pruebas

data class Worker (val name: String = "Anónimo", val age: Int = 18, val work: String = "Desconocido"){
    var lastWork = ""
}