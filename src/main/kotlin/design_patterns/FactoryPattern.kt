package design_patterns


// check links :
// - https://www.youtube.com/watch?v=qUeHnjXSCMg
// - https://www.youtube.com/watch?v=-MHnvg7xZsI&list=PLWGY69Afe7QaO9KUWiMdzQX8d-Ea-N9an&index=2
// - https://medium.com/@ericdiazcodes/factory-design-pattern-in-kotlin-and-java-made-easy-and-simple-8be188396469

fun main(args: Array<String>) {
    //val currency = CurrencyFactory.getCurrency(Country.China)
    //println(currency)

    val factory = DocumentFactoryImpl().createDocument(FileExtension.TXT)
}



////////// Example 1 //////////
object CurrencyFactory {
    fun getCurrency(country: Country): Currency {
        return when (country) {
            is Country.Germany -> Currency("EUR")

            is Country.England -> Currency("GBP")

            is Country.Dubai -> Currency("AED")

            is Country.China -> Currency("YEN")

            else -> throw IllegalArgumentException("no implementation found")
        }
    }
}

sealed class Country {
    object Germany : Country()

    object England : Country()

    object Dubai : Country()

    object China : Country()
}

class Currency(private val currencyCode: String){
    override fun toString(): String {
        return "{country code : ${this.currencyCode}}"
    }
}


////////// Example 2 //////////
interface Document{
    fun save()
}

class PdfDocument : Document {
    override fun save() {
        println("PDF saved ...")
    }
}

class WordDocument : Document {
    override fun save() {
        println("Word saved ...")
    }
}

class TextDocument : Document {
    override fun save() {
        println("Text saved ...")
    }
}

interface DocumentFactory{
    fun createDocument(extension : FileExtension) : Document
}

class DocumentFactoryImpl : DocumentFactory{
    override fun createDocument( extension : FileExtension ) : Document{
        return when (extension) {
            FileExtension.TXT -> PdfDocument()
            FileExtension.PDF -> TextDocument()
            FileExtension.WORD -> WordDocument()
        }
    }
}

enum class FileExtension{
    TXT,
    PDF,
    WORD
}


