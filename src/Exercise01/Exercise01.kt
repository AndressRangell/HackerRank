package Exercise01

fun main(args: Array<String>) {
    //10 20 20 10 10 30 50 10 20
    val socks = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    val pairs = sockMerchant(socks)

    println(pairs)
}

fun sockMerchant(socks: Array<Int>): Int {
    val sockMap = mutableMapOf<Int, Int>()
    var count = 0
    socks.forEach { sock ->
        if(sockMap.contains(sock)){
            sockMap[sock] = sockMap.getValue(sock) + 1
        }else{
            sockMap[sock] = 1
        }
    }
    sockMap.forEach { sock ->
        count += sock.value / 2
    }
    return count
}
