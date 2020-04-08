package hancock.julie.dontgethangry.models

data class Restaurant (
    var name: String, //"Chick-fil-A"
    var image: Int,
    var type: String, //"Fast Food"
    var price: String, //"$"
    var address: String, //"484 W Bulldog Ln"
    var milesAway: Double, //7.2
    var hours: String, //10am-8pm
    var website: String, //"www.chickfila.com"
    var rating: Double
) {

    override fun toString(): String {
        return name
    }

}