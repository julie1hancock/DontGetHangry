package hancock.julie.dontgethangry.models

import hancock.julie.dontgethangry.R

object Singleton {

    var theyPicked = mutableListOf<Restaurant>()
    var theyRejected = mutableListOf<Restaurant>()
    var allRestaurants = setup()

    var youPicked = mutableListOf<Restaurant>()
    var youRejected = mutableListOf<Restaurant>()


    private fun setup(): MutableList<Restaurant> {
        val spicy = getSpicyThai()
        val zupas = getZupas()
        val jDawgs = getJDawgs()
        val costaVida = getCostaVida()
        val chickFilA = getChickFilA()
        val station22 = getStation22()
        val waffleLove = getWaffleLove()
        val tucanos = getTucanos()
        val rodizioGrill = getRodizioGrill()
        val laJollaGroves = getLaJollaGroves()
        val slabPizza = getSlabPizza()

//        theyPicked.add(chickFilA)
        theyPicked.add(waffleLove)

        theyPicked.add(spicy)
        theyPicked.add(jDawgs)
        theyPicked.add(costaVida)
        theyPicked.add(station22)
        theyPicked.add(slabPizza)
        theyPicked.add(zupas)
        theyPicked.add(tucanos)
        theyPicked.add(rodizioGrill)
        theyPicked.add(laJollaGroves)


        val list = mutableListOf<Restaurant>()
        list.add(tucanos) //9
        list.add(spicy) //1
        list.add(chickFilA) //4
        list.add(costaVida) //3
        list.add(rodizioGrill) //10
        list.add(station22) //5
        list.add(slabPizza) //7
        list.add(zupas) //8
        list.add(waffleLove) //6
        list.add(laJollaGroves) //11
        list.add(jDawgs) //2
        return list

    }

    private fun getLaJollaGroves() = Restaurant(
        name = "La Jolla Groves",
        type = "New American restaurant",
        price = "$$$",
        address = "4801 N University Ave, Provo, UT 84604",
        milesAway = 4.7,
        hours = "11am-8pm",
        website = "www.lajollagroves.com",
        rating = 4.1,
        image = R.drawable.lajollalogo
    )
    private fun getRodizioGrill() = Restaurant(
        name = "Rodizio Grill",
        type = "Steak house",
        price = "$$$",
        address = "4801 N University Ave Ste 710, Provo, UT 84604",
        milesAway = 4.5,
        hours = "11:30am-9pm",
        website = "www.rodiziogrill.com",
        rating = 4.4,
        image = R.drawable.rodiziogrilllogo
    )
    private fun getTucanos() = Restaurant(
        name = "Tucanos Brazilian Grill",
        type = "Buffet restaurant",
        price = "$$$",
        address = "545 E University Pkwy, Orem, UT 84097",
        milesAway = 3.8,
        hours = "11am-11pm",
        website = "www.tucanos.com",
        rating = 4.6,
        image = R.drawable.tucanoslogo
    )
    private fun getZupas() = Restaurant(
        name = "Café Zupas",
        type = "Fast food restaurant",
        price = "$$",
        address = "408 W 2230 N, Provo, UT 84604",
        milesAway = 2.5,
        hours = "11am-9pm",
        website = "www.cafezupas.com",
        rating = 4.3,
        image = R.drawable.zupaslogo
    )
    private fun getSlabPizza() = Restaurant(
        name = "SLABPizza",
        type = "Pizza restaurant",
        price = "$$",
        address = "671 E 800 N, Provo, UT 84606",
        milesAway = .4,
        hours = "11am-11pm",
        website = "www.slabpizza.com",
        rating = 4.6,
        image = R.drawable.slabpizzalogo
    )
    private fun getWaffleLove() = Restaurant(
        name = "Waffle Love",
        type = "Restaurant",
        price = "$$",
        address = "1831 N State St, Provo, UT 84604",
        milesAway = 2.6,
        hours = "9am-8pm",
        website = "www.waffluv.com",
        rating = 4.5,
        image = R.drawable.wafflelovelogo
    )
    private fun getStation22() = Restaurant(
        name = "Station 22",
        type = "Restaurant",
        price = "$$",
        address = "22 W Center St, Provo, UT 84601",
        milesAway = 1.8,
        hours = "11am-10pm",
        website = "www.station22cafe.com",
        rating = 4.1,
        image = R.drawable.station22logo
    )
    private fun getChickFilA() = Restaurant(
        name = "Chick-fil-A",
        type = "Fast food restaurant",
        price = "$",
        address = "484 W Bulldog Ln, Provo, UT 84604",
        milesAway = 1.9,
        hours = "6:30am-10pm",
        website = "www.chick-fil-a.com",
        rating = 4.5,
        image = R.drawable.chickfilalogo
    )
    private fun getCostaVida() = Restaurant(
        name = "Costa Vida",
        type = "Mexican restaurant",
        price = "$",
        address = "1200 N University Ave, Provo, UT 84606",
        milesAway = 1.4,
        hours = "10:30am-10pm",
        website = "www.costavida.com",
        rating = 4.4,
        image = R.drawable.costavidalogo
    )
    private fun getJDawgs() = Restaurant(
        name = "J Dawgs",
        type = "Hot dog restaurant",
        price = "$",
        address = "858 700 East-, Provo, UT 84606",
        milesAway = 0.6,
        hours = "11am-7pm",
        website = "www.jdawgs.com",
        rating = 4.7,
        image = R.drawable.jdawgslogo
    )
    private fun getSpicyThai() = Restaurant(
        name = "Spicy Thai",
        type = "Thai restaurant",
        price = "$",
        address = "3230 N University Ave, Provo, UT 84604",
        milesAway = 2.9,
        hours = "11am-9:30pm",
        website = "www.spicythaiprovo.com",
        rating = 4.4,
        image = R.drawable.spicythailogo
    )


    fun addPicked(r: Restaurant){
        youPicked.add(r)
    }

    fun addRejected(r: Restaurant){
        youRejected.add(r)
    }

}