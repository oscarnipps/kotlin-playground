package designpatterns

//Notes : Factory Design Pattern
//creational pattern used to provide some functionality / instantiation for the calling element without needing
//to know the internal implementation

fun main() {
    val portugal = Country.Portugal
    val currencyCode = CurrencyFactory.currencyProvider(portugal)
    print("country $portugal uses $currencyCode")
}

sealed class Country{
    object Portugal : Country()
    object Hungary : Country()
    object Netherlands : Country()
    object Austria : Country()
    object Mauritius : Country()
}

class Currency(val code : String)

object CurrencyFactory{

    fun currencyProvider(country: Country) : Currency{
        return when (country) {
            Country.Austria -> Currency("EURO")

            Country.Hungary -> Currency("FORINT")

            Country.Mauritius -> Currency("DOLLARS")

            Country.Netherlands -> Currency("EURO")

            Country.Portugal -> Currency("EURO")
        }
    }
}
