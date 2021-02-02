package com.example.firstapp.model

import java.io.Serializable

data class Publication(
    var id: Int,
    var icon: String,
    var name: String,
    var phoneNumber: String,
    var age: Int,
    var image: MutableList<String>,
    val randomImage: String,
    var like: Int,
    var isFavorite: Boolean = false
): Serializable

val imageArray = mutableListOf<String>().apply {
    add("https://www.meme-arsenal.com/memes/50569ac974c29121ff9075e45a334942.jpg")
    add("https://resheto.net/images/mater/pozitivnye_kartinki_2.jpg")
    add("https://avatarko.ru/img/kartinka/1/avatarko_anonim.jpg")
    add("https://bipbap.ru/wp-content/uploads/2017/08/LEpwl8j7fQ.jpg")
    add("https://i.mycdn.me/i?r=AzEPZsRbOZEKgBhR0XGMT1Rkrpshi6PfpnM0r8rUCAGB9qaKTM5SRkZCeTgDn6uOyic")
}

val publicationArray = mutableListOf<Publication>().apply {
    add(
        Publication(
            1,
            "https://klike.net/uploads/posts/2018-06/1530090978_1.jpg",
            "Elisa",
            "999777222107",
            30,
            imageArray,
            imageArray.random(),
            365346
        )
    )
    add(
        Publication(
            2,
            "https://ribalych.ru/wp-content/uploads/2020/03/smeshnye-kartinki-nastroenie_001-1.jpg",
            "Jenny",
            "999777222111",
            35,
            imageArray,
            imageArray.random(),
            0
        )
    )
    add(
        Publication(
            3,
            "https://the-flow.ru/uploads/images/resize/830x0/adaptiveResize/15/77/94/35/48/bb23aed40cd7.jpg",
            "Andry",
            "999777555333",
            29,
            imageArray,
            imageArray.random(),
            3555
        )
    )
    add(
        Publication(
            4,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRmXKAUMbEtzmIr9CdybO3TAYkMP8bcbBvPg&usqp=CAU",
            "Leila",
            "999777555112",
            40,
            imageArray,
            imageArray.random(),
            65
        )
    )
    add(
        Publication(
            5,
            "https://lh3.googleusercontent.com/proxy/-ZufMQfaLpO7w5oMKcBEF3TO8_nd4k4RfyXzwSLbUF7_36_WTxrJbAiW2Lm-Q8e09BABf_-VJ0yK3Z7fTJ9FwCZnh5s",
            "Andy",
            "6475773747",
            25,
            imageArray,
            imageArray.random(),
            0
        )
    )
    add(
        Publication(
            6,
            "https://www.prikol.ru/wp-content/uploads/2020/07/kartinki-29072020-001.jpg",
            "Anabel",
            "999777222111",
            40,
            imageArray,
            imageArray.random(),
            0
        )
    )
    add(
        Publication(
            7,
            "https://chto-takoe-lyubov.net/wp-content/uploads/2020/10/Davay-pomirimsya-lyubimaya.jpg",
            "Keisy",
            "999777242106",
            83,
            imageArray,
            imageArray.random(),
            0
        )
    )

}
