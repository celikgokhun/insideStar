package com.celik.starlib.data.model

data class Star(
    val size: String,
    val color: String =
        if (size == "S") {
            listOf("Red", "Blue", "Green").random()
        } else {
            listOf("Yellow", "Purple", "Gray").random()
        },
    val brightness:String =
        listOf("Bright", "Not so much").random()

)
