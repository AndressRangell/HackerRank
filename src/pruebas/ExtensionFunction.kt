package pruebas

import java.text.SimpleDateFormat
import java.util.*

fun Date.customFormat(): String{
    val formatter = SimpleDateFormat("HH:mm:ss - dd-MM-yyyy", Locale.getDefault())
    return formatter.format(this)
}

val Date.size: Int
        get() = this.customFormat().length