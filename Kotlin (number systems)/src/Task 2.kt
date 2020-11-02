import kotlin.math.pow


fun toDecimal(number:String, basis:Double):Double{
    var numberInt = number.toInt()
    var result = 0.0
    for (i in number.indices){
        result += (numberInt%10)*basis.pow(i)
        numberInt/=10
    }

    return result
}

fun toOther(number:Int, basis:Int):String{
    var numberInt = number
    var result = ""
    while(numberInt!=0){
        result+=(numberInt%basis).toString()
        numberInt/=basis
    }
    return result
}

fun main() {
    println("Введите основание исходной системы счисления:")
    val basisString = readLine()!!
    val basis = basisString.toDouble()
    println("Введите число в данной системе счисления: ")
    val numberString = readLine()!!
    val decimal = (toDecimal(numberString,basis)).toInt()
    println("Введите основание желаемой системы счисления: ")
    val desiredBasisString = readLine()!!
    val desiredBasis = desiredBasisString.toInt()
    println("Исходное число в желаемой системе счисления: ${(toOther(decimal,desiredBasis)).reversed()}")
}
