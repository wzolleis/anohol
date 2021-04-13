import domain.saga.DatenUmwandelnSaga
import java.io.File
import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    val input = DatenUmwandelnSaga::class.java.getResource(args[0])?.toURI()
        ?: throw IllegalArgumentException("Input nicht gefunden")
    val output = args[1]
    val inputFile = File(input)
    val outputFile = File(output)
    val result = DatenUmwandelnSaga().readFile(inputFile)
    DatenUmwandelnSaga().writeFile(result, outputFile)
    println(result)
}