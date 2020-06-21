package hancock.julie.dontgethangry.models

//TODO: cleanup
data class Restaurant(
    var name: kotlin.String, //"Chick-fil-A"
    var image: kotlin.Int,
    var type: kotlin.String, //"Fast Food"
    var price: kotlin.String, //"$"
    var address: kotlin.String, //"484 W Bulldog Ln"
    var milesAway: kotlin.Double, //7.2
    var hours: kotlin.String, //10am-8pm
    var website: kotlin.String, //"www.chickfila.com",
    val rating: kotlin.Double
) {

    override fun toString(): String {
        return name
    }

    fun getDisplayImage() : Int = image
    fun getDisplayMilesAway() : String = "$milesAway miles away"
    fun getDisplayName() : String = name
    fun getDisplayTypeAndPrice() : String = "$type + $price"
    fun getDisplayAddress() : String = "Address: $address "
    fun getDisplayHours() : String = "Hours: $hours"
    fun getDisplayWebsite() : String = website

}