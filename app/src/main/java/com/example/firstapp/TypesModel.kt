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
    add(City(R.mipmap.spain, "Spain", "Ло́ндон (англ. London [ˈlʌndən] Информация о файле слушать) — столица и крупнейший город Соединённого Королевства Великобритании и Северной Ирландии. Административно образует регион Англии Большой Лондон, разделённый на 33 самоуправляемых территории. Население составляет 8 908 081 чел.[2] (2018 г.) — это третий[4] по величине город Европы. Образует агломерацию Большой Лондон и более обширный метрополитенский район, являющиеся по численности населения в ЕС второй городской и первой региональной агломерациями, соответственно. Расположен на юго-востоке острова Великобритания, на равнине в устье Темзы, вблизи Северного моря. Главный политический, экономический и культурный центр Соединённого Королевства.", "Madrid", "46б94", "spain", "505,990"))
    add(City(R.mipmap.italy, "Italy", "Italy is a unitary republic of parliamentary type", "Rome", "60,36m", "italy", "301 338 км²"))
    add(City(R.mipmap.tokyo, "Tokyo", "Tokyo being one of the largest cities on earth", "tokyo", "126,5", "japan", "377 915 км²"))
    add(City(R.mipmap.djakarta, "Djakarta", "Located on the northwest coast of Java at the confluence of the Chilivung River", "djakarta", "9,608", "indonesia", "661,5 км²"))
    add(City(R.mipmap.kaliforniya, "Kaliforniya", "California at various times was under the rule of Spain and Mexico", "kaliforniya", "100", "USA", "423 970 км²"))
    add(City(R.mipmap.paris, "Paris", "Population: 2.2 million people (2016), the fifth largest city in the European Union [2]", "paris", "2,2ml", "france", "643 801 км²"))

}