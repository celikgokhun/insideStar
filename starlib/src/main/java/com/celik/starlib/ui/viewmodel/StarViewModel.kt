package com.celik.starlib.ui.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.celik.starlib.data.model.Star
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class StarViewModel: ViewModel(){

    var starList =  mutableStateListOf<Star>()

    private val gson = Gson()

    fun addStar(star: Star) {
        starList.add(star)
    }

    fun clearSky() {
        starList.clear()
    }

    fun saveDataToFile(context: Context, data: List<Star>) {
        try {
            context.openFileOutput(Companion.FILE_NAME, Context.MODE_PRIVATE).use { outputStream ->
                OutputStreamWriter(outputStream).use { writer ->
                    writer.write(gson.toJson(data))
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun readDataFromFile(context: Context): List<Star> {
        try {
            context.openFileInput(Companion.FILE_NAME).use { inputStream ->
                InputStreamReader(inputStream).use { reader ->
                    BufferedReader(reader).use {
                        val stringBuilder = StringBuilder()
                        var line: String?
                        while (it.readLine().also { line = it } != null) {
                            stringBuilder.append(line).append("\n")
                        }
                        return getJsonStringStarList(stringBuilder.toString())
                    }
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
            return emptyList()
        }
    }

    private fun getJsonStringStarList(jsonString: String): List<Star> {
        val typeToken = object : TypeToken<List<Star>>() {}.type
        return gson.fromJson(jsonString, typeToken) ?: emptyList()
    }

    companion object {
        private const val FILE_NAME = "starData.txt"
    }

}

