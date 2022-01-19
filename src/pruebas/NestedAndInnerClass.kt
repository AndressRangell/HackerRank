package pruebas

class NestedAndInnerClass {

    private val one = 1

    private fun getOne(): Int{
        return one
    }

    class NestedClass{
        fun sumOne(number: Int): Int{
            return number + 1
        }
    }

    inner class InnerClass{
        fun sumTwo(number: Int): Int{
            return number + one + getOne()
        }
    }

}