import java.io.File

fun main(args: Array<String>) {
    if (args.size != 1)  {
        println("Dateiname angeben")
        System.exit(-1)
    }
    val file = args[0]
    Main().start(file)
}

class Main {
    fun start(fileName: String) {
        val file = File(fileName)
        val content = file.readText()
        val t1 = ersetzeAnfuehrungszeichen(content)
        val t2 = extrahiereArray(t1)
        val t3 = ersetzeNamen(t2)
        val t4 = fuegeArrayHinzu(t3)
        println(t4)
    }

    fun ersetzeAnfuehrungszeichen(content: String): String {
        return content.replace("&\";", "\"")
    }

    fun extrahiereArray(content: String): String {
        return content.substringAfter("[").substringBefore("]")
    }

    fun ersetzeNamen(content: String): String {
        return content
    }

    fun fuegeArrayHinzu(content: String): String {
        return "[$content]"
    }
}