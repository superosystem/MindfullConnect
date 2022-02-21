class Car(Type:String, Model:Int, Price:Double, MilesDrive:Int, Owner:String) {

    var Owner:String?=null
    var Price:Double?=null
    var MilesDrive:Int?=null
    var Model:Int?=null
    var Type:String?=null

    init {
        println("Type: $Type")
        println("Model: $Model")
        println("Price: $Price")
        println("Miles Drive: $MilesDrive")
        println("Owner: $Owner")
    }

    fun GetPrice():Double? {
        return this.Price;
    }

    fun GetOwner():String? {
        return this.Owner;
    }
}

fun main(args:Array<String>) {
    var guCar = Car("BMW", 2015, 1000.0, 105, "Gusryl")
    var muCar = Car("Honda", 2017, 9000.0, 200, "Mubarok")
}