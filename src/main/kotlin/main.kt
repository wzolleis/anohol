import domain.saga.DatenUmwandelnSaga
import java.io.File
import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    val fileName = DatenUmwandelnSaga::class.java.getResource("/urlaub_test.json")?.toURI()
        ?: throw IllegalArgumentException("Datei nicht gefunden")
    val file = File(fileName)
    val result = DatenUmwandelnSaga().start(file)
    println(result)

}