package com.example.firstapp

var array = mutableListOf<String>()

var imageArray = mutableListOf<Int>().apply {
    add(R.mipmap.spain)
    add(R.mipmap.italy)
    add(R.mipmap.tokyo)
    add(R.mipmap.djakarta)
    add(R.mipmap.kaliforniya)
    add(R.mipmap.paris)
}

var cityArray = mutableListOf<City>(). apply {
    add(City(R.mipmap.spain, "Spain", "Spain is washed by the Atlantic Ocean to the north and west"))
    add(City(R.mipmap.italy, "Italy", "Italy is a unitary republic of parliamentary type"))
    add(City(R.mipmap.tokyo, "Tokyo", "Tokyo being one of the largest cities on earth"))
    add(City(R.mipmap.djakarta, "Djakarta", "Located on the northwest coast of Java at the confluence of the Chilivung River"))
    add(City(R.mipmap.kaliforniya, "Kaliforniya", "California at various times was under the rule of Spain and Mexico"))
    add(City(R.mipmap.paris, "Paris", "Population: 2.2 million people (2016), the fifth largest city in the European Union [2]"))

}