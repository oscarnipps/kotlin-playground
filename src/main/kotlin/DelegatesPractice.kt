import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/*
* - Useful links : https://www.youtube.com/watch?v=lZTtddPfPoU
* - Useful links : https://www.digitalocean.com/community/tutorials/composition-vs-inheritance
*
* - Delegation is an OOP pattern that favours composition over inheritance implementation (they both promote code reuse but with different approaches)
*     -> Composition defines a "has-a" relationship with objects is loosely coupled
*     -> Inheritance defines a "is-a" relationship with objects is tightly coupled
*
* - custom delegate class by implementing two operator methods (getValue and setValue)
*
* - pre-built lambda exists such as :
*     -> lazy : returns a lazy class that serves as a delegate for a lazy prop where the first call to the get method executes
*        the lambda and remembers the result , subsequent calls return the remembered result
*
*     -> observable : 'Delegates.observable{...}' observes the changes to the value / property (takes in the initialValue
*        of the property and the lambda that would be executed whenever there's an update to the value)
*
*     -> vetoable : intercept's assignments and veto them (english for vetting or checking them). value would only be
*        updated when the condition results to true
*
*
*/
fun main(args: Array<String>) {
    val iPhone12 = IPhone12()

    val iPhone13 = IPhone13()

    println(iPhone13)

    println("Iphone 12 info : ${iPhone12.getName()} | ${iPhone12.getVersion()} | ${iPhone12.getNumberOfCores()} | camera type : ${iPhone12.getPhoneDeviceCameraType()}")

    iPhone12.updateDeviceCameraType("Instagram Camera-Z")
}

interface OS {
    fun getName(): String
    fun getVersion(): String
    fun getNumberOfCores(): Int
}

open class IOS : OS {
    override fun getName(): String {
        println("This is an iOS device")
        return "iOS"
    }

    override fun getVersion(): String {
        println("Current iOS version : 14.0.0")
        return "14.0.0"
    }

    override fun getNumberOfCores(): Int {
        return 4
    }

    override fun toString(): String {
        return "name = ${this.getName()} | version = ${this.getVersion()} | cores = ${this.getNumberOfCores()}"
    }
}

//using inheritance implementation
class IPhone13 : IOS() {
    override fun getNumberOfCores(): Int {
        return 6
    }

    override fun getName(): String {
        return "IPhone 13"
    }
}

//using composition via delegation
class IPhone12 : OS by IOS() {

    //property delegate
    //if the value can be modified then a setter must be provided and "var would be used"
    private var deviceCameraType: String by DeviceCameraType()

    //pre-built kotlin delegate type
    //first call to the get method (when the field is accessed) executes the lambda and remembers the result , subsequent calls return the remembered result
    val processorSize: Int by lazy {
        //heavy computation
        10000
    }

    //pre-built kotlin observable delegate type
    val hasSimCardInserted: Boolean by Delegates.observable(false) { property, oldValue, newValue -> }

    //pre-built kotlin vetoable delegate type
    //value would only be updated when the condition results to true
    val iCloudVersion: Int by Delegates.vetoable(0) { property: KProperty<*>, oldIcloudVersion: Int, newIcloudVersion: Int ->
        newIcloudVersion > oldIcloudVersion
    }

    override fun getName(): String {
        return "IPhone 12"
    }

    fun updateDeviceCameraType(cameraType: String) {
        this.deviceCameraType = cameraType
    }

    fun getPhoneDeviceCameraType(): String {
        return this.deviceCameraType
    }

    override fun toString(): String {
        return "name = ${getName()} | version = ${getVersion()} | cores = ${getNumberOfCores()}"
    }

}

//custom delegate class for device name
//kProperty - Kotlin property
class DeviceCameraType {
    operator fun getValue(classRef: Any?, property: KProperty<*>): String {
        println("-class : $classRef | property : $property | propertyName : ${property.name}")
        return "Camera-360"
    }

    operator fun setValue(classRef: Any?, property: KProperty<*>, value: String) {
        println("value : $value | class : $classRef | property : $property | propertyName : ${property.name}")
    }
}

//function delegates
fun getPhotosVersion() {}


