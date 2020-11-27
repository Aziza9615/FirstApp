package com.example.firstapp

import java.io.Serializable

data class News(
   var image: String,
    var title: String,
    var description: String
) :Serializable

var newsArray = mutableListOf<News>(). apply {
    add(News("https://cdn.londonandpartners.com/assets/73295-640x360-london-skyline-ns.jpg",
        "По словам Галины Байтерек, в дальнейшем будет проводиться тщательная проверка и по ее результатам будут принимать","Они также выяснили, что на месте обитания детенышей барса были установлены фотоловушки"))
    add(News("https://cdn.londonandpartners.com/assets/73295-640x360-london-skyline-ns.jpg",
        "На пресс-конференции 12 ноября Садыр Жапаров заявил, что готов помиловать тех, кто несправедливо находится под стражей","Инспекторы Межрегионального управления Госэкотехинспекции по Таласской области провели разъяснительную работу с чабанами участка Каракол"))
    add(News("https://cdn.londonandpartners.com/assets/73295-640x360-london-skyline-ns.jpg",
        "Все граждане, к которым применено решение о помиловании", "Ранее сообщалось, что из мест лишения свободы освобождены 230 человек, сокращены сроки в отношении 38 осужденных"))
    add(News("https://cdn.londonandpartners.com/assets/73295-640x360-london-skyline-ns.jpg",
        "Инспекторы Госэкотехинспекции провели разъяснительную работу с чабанами участка Каракол Таласского района и призвали к бережному отношению к окружающей среде","В Таласе чабаны сняли на видео двух детенышей снежного барса. Видео опубликовано на Telegram-канал"))
}
