package com.celik.starlib.util

import com.celik.starlib.data.model.Star

fun printlnLogger(stars: List<Star>) {
    println(stars.toList())

    var numberOfBrightStar = 0

    for (star in stars) {
        if (star.brightness == "Bright") {
            numberOfBrightStar += 1
        }
    }
    if(numberOfBrightStar>0){
        println("We have $numberOfBrightStar bright star/s.")
    } else {
        println("We do not have any bright star")
    }

}