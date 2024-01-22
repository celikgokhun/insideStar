package com.celik.starlib.util

import com.celik.starlib.data.model.Star
import org.junit.Assert
import org.junit.Test

class TestUtil {

    @Test
    fun `given starList, when printlnLogger called, results assertion`()  {
        // Given
        val testStarList = listOf<Star>(
            Star("S", "Red", "Bright"),
            Star("B", "Purple", "Bright"),
            Star("S", "Blue", "Not so much")
        )

        val expectedLogValue = "[Star(size=S, color=Red, brightness=Bright), Star(size=B, color=Purple, brightness=Bright), Star(size=S, color=Blue, brightness=Not so much)]We have 2 bright star/s."

        Assert.assertEquals(println(expectedLogValue), printlnLogger(testStarList))
    }
}