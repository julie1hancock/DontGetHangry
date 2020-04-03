package hancock.julie.dontgethangry

object Singleton {

    var restaurants = setup()
    var theyPicked = mutableListOf<Restaurant>()
    var theyRejected = mutableListOf<Restaurant>()


    private fun setup(): MutableList<Restaurant> {
        val spicy = getSpicyThai()
        val jDawgs = getJDawgs()
        val costaVida = getCostaVida()
        val chickFilA = getChickFilA()
        val station22 = getStation22()
        val waffleLove = getWaffleLove()
        val slabPizza = getSlabPizza()
        val zupas = getZupas()
        val tucanos = getTucanos()
        val rodizioGrill = getRodizioGrill()
        val laJollaGroves = getLaJollaGroves()
        val fatDaddys = getFatDaddys()

        theyPicked.add(chickFilA)
        theyPicked.add(waffleLove)

        theyRejected.add(spicy)
        theyRejected.add(jDawgs)
        theyRejected.add(costaVida)
        theyRejected.add(station22)
        theyRejected.add(slabPizza)
        theyRejected.add(zupas)
        theyRejected.add(tucanos)
        theyRejected.add(rodizioGrill)
        theyRejected.add(laJollaGroves)
        theyRejected.add(fatDaddys)



        var list = mutableListOf<Restaurant>()
        list.add(spicy)
        list.add(jDawgs)
        list.add(costaVida)
        list.add(chickFilA)
        list.add(station22)
        list.add(waffleLove)
        list.add(slabPizza)
        list.add(zupas)
        list.add(tucanos)
        list.add(rodizioGrill)
        list.add(laJollaGroves)
        list.add(fatDaddys)
        return list
    }

    private fun getFatDaddys() =     Restaurant(name = "Fat Daddy's Pizza",       type = "Pizza restaurant",        price = "$$$", address = "1528 N Freedom Blvd, Provo, UT 84604",           milesAway = 1.8, hours = "11:30am-10pm", website = "www.fatdaddyspizzeria.com", rating = 4.8)
    private fun getLaJollaGroves() = Restaurant(name = "La Jolla Groves",         type = "New American restaurant", price = "$$$", address = "4801 N University Ave, Provo, UT 84604",         milesAway = 4.7, hours = "11am-8pm",     website = "www.lajollagroves.com",     rating = 4.1)
    private fun getRodizioGrill() =  Restaurant(name = "Rodizio Grill",           type = "Steak house",             price = "$$$", address = "4801 N University Ave Ste 710, Provo, UT 84604", milesAway = 4.5, hours = "11:30am-9pm",  website = "www.rodiziogrill.com",      rating = 4.4)
    private fun getTucanos() =       Restaurant(name = "Tucanos Brazilian Grill", type = "Buffet restaurant",       price = "$$$", address = "545 E University Pkwy, Orem, UT 84097",          milesAway = 3.8, hours = "11am-11pm",    website = "www.tucanos.com",           rating = 4.6)
    private fun getZupas() =         Restaurant(name = "Café Zupas",              type = "Fast food restaurant",    price = "$$",  address = "408 W 2230 N, Provo, UT 84604",                  milesAway = 2.5, hours = "11am-9pm",     website = "www.cafezupas.com",         rating = 4.3)
    private fun getSlabPizza() =     Restaurant(name = "SLABPizza",               type = "Pizza restaurant",        price = "$$",  address = "671 E 800 N, Provo, UT 84606",                   milesAway = .4,  hours = "11am-11pm",    website = "www.slabpizza.com",         rating = 4.6)
    private fun getWaffleLove() =    Restaurant(name = "Waffle Love",             type = "Restaurant",              price = "$$",  address = "1831 N State St, Provo, UT 84604",               milesAway = 2.6, hours = "9am-8pm",      website = "www.waffluv.com",           rating = 4.5)
    private fun getStation22() =     Restaurant(name = "Station 22",              type = "Restaurant",              price = "$$",  address = "22 W Center St, Provo, UT 84601",                milesAway = 1.8, hours = "11am-10pm",    website = "www.station22cafe.com",     rating = 4.1)
    private fun getChickFilA() =     Restaurant(name = "Chick-fil-A",             type = "Fast food restaurant",    price = "$",   address = "484 W Bulldog Ln, Provo, UT 84604",              milesAway = 1.9, hours = "6:30am-10pm",  website = "www.chick-fil-a.com",       rating = 4.5)
    private fun getCostaVida() =     Restaurant(name = "Costa Vida",              type = "Mexican restaurant",      price = "$",   address = "1200 N University Ave, Provo, UT 84606",         milesAway = 1.4, hours = "10:30am-10pm", website = "www.costavida.com",         rating = 4.4)
    private fun getJDawgs() =        Restaurant(name = "J Dawgs",                 type = "Hot dog restaurant",      price = "$",   address = "858 700 East-, Provo, UT 84606",                 milesAway = 0.6, hours = "11am-7pm",     website = "www.jdawgs.com",            rating = 4.7)
    private fun getSpicyThai() =     Restaurant(name = "Spicy Thai",              type = "Thai restaurant",         price = "$",   address = "3230 N University Ave, Provo, UT 84604",         milesAway = 2.9, hours = "11am-9:30pm",  website = "www.spicythaiprovo.com",    rating = 4.4)

    var youPicked = mutableListOf<Restaurant>()
    var youRejected = mutableListOf<Restaurant>()





}







/*

can maybe start may 11th - we'll see
down 9%
400MIL/QUARTER
neil despain/gary<

liam
andrew riley, arther, bart, dan shelly, edwardo, getika, heidi, jane?, jim, casey, keld, neil, spencer griffen, steve burns, one more

what's going to be different?
Shanes team - are they still all there do you know?
Bart's team?
with the layoffs is it still going to be as high of an hiring rate after graduation?

 */