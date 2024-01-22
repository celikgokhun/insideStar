package com.celik.starlib.ui

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.celik.starlib.data.model.Star
import com.celik.starlib.util.printlnLogger
import com.celik.starlib.ui.component.Sky
import com.celik.starlib.ui.viewmodel.StarViewModel

@Composable
fun AddStarInterface(context: Context) {

    val (isVisible, setIsVisible) = remember { mutableStateOf(true) }

    val starViewModel:StarViewModel = viewModel()

    val stars = remember { starViewModel.starList }

    val starsSaved = remember { starViewModel.readDataFromFile(context = context) }

    if (stars.size < starViewModel.readDataFromFile(context = context).size) {
        for(star in starsSaved) {
            stars.add(star)
        }
    } else {
        for(star in stars) {
            starViewModel.saveDataToFile(context = context, stars)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(3.dp)
            .background(Color.Black)
    ) {

        Sky(stars = stars)

        if (!isVisible) {
            Text(text = "Sky is full !")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(5.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(
                onClick = {
                    if (stars.size<10) {
                        starViewModel.addStar(Star(size = "S"))
                        starViewModel.saveDataToFile(context = context, stars)
                    } else {
                        setIsVisible(false)
                    }
                    printlnLogger(stars)

                },
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(
                    text = "Small Star",
                    color = Color.White
                )
            }

            Button(
                onClick = {
                    if (stars.size<10) {
                        starViewModel.addStar(Star(size = "B"))
                        starViewModel.saveDataToFile(context = context, stars)
                    } else {
                        setIsVisible(false)
                    }
                    printlnLogger(stars)

                },
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(
                    text = "Big Star",
                    color = Color.White
                )
            }

            Button(
                onClick = {
                    printlnLogger(stars)
                    starViewModel.clearSky()
                    starViewModel.saveDataToFile(context = context, listOf())
                    setIsVisible(true)
                },
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(
                    text = "Reset",
                    color = Color.White
                )
            }

        }

    }

}