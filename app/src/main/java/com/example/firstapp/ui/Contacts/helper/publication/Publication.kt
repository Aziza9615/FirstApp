package com.example.firstapp.ui.Contacts.helper.publication

data class Publication (
    var name: String,
    var phoneNumber: String,
    var age: Int,
    var image: MutableList<String>
)

val imageArray = mutableListOf<String>().apply {
    add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBQQlFefFKc0MgAocMwl9XZKou32VgeBqf_Q&usqp=CAU")
    add("https://resheto.net/images/mater/pozitivnye_kartinki_2.jpg")
    add("https://lh3.googleusercontent.com/proxy/oDBFBkA6R9exqIj3mLrwu6erR3GxUQMLJjNSXDShqlkGl9Jly3O8Py2U5DEM2nqIkd0lN2Rhm4Th7F0SZreg5JNrPqq_hOB4UqP3FCXT6IkwkzQK9z4jE6uFiVAmij1mdpreDuBp")
    add("https://avatarko.ru/img/kartinka/1/avatarko_anonim.jpg")
    add("https://www.meme-arsenal.com/memes/50569ac974c29121ff9075e45a334942.jpg")
    add("https://bipbap.ru/wp-content/uploads/2017/08/LEpwl8j7fQ.jpg")
    add("https://i.mycdn.me/i?r=AzEPZsRbOZEKgBhR0XGMT1Rkrpshi6PfpnM0r8rUCAGB9qaKTM5SRkZCeTgDn6uOyic")
}

val publicationArray = mutableListOf<Publication>().apply {
    add(
        Publication(
            "John",
            "999777222107",
            30,
            imageArray
        )
    )
    add(
        Publication(
            "Sara",
            "999777222111",
            35,
            imageArray
        )
    )
    add(
        Publication(
            "Andry",
            "999777555333",
            29,
            imageArray
        )
    )
    add(
        Publication(
            "German",
            "999777555112",
            40,
            imageArray
        )
    )
    add(
        Publication(
            "Klara",
            "999777234198",
            25,
            imageArray
        )
    )
    add(
        Publication(
            "Anna",
            "999777222111",
            40,
            imageArray
        )
    )
    add(
        Publication(
            "Jinny",
            "999777242106",
            83,
            imageArray
        )
    )
}
