package pruebas

class Programmer(val name: String, val age: Int, val languajes: List<Languajes>) {

    enum class Languajes(val dificutl: Int) {
        KOTLIN(7),
        SWIFT(8),
        JAVA(9),
        JAVASCRIPT(6),
        PYTHON(5);

        fun information(): String{
            return "Grado de dificultad: $dificutl"
        }

    }

    fun presentation(): String {
        var message = "Soy $name, tengo $age años y programo en: "
        languajes.forEach {
            message += "\n${it.name} - ${it.information()}"
        }
        return message
    }

}