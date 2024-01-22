package com.celik.starlib.ui.component

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.celik.starlib.data.model.Star
import android.graphics.Color as AndroidColor

@Composable
fun StarView(
    star: Star
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(5.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            AndroidView(
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(3.dp),
                factory = { context ->
                    WebView(context).apply {
                        setBackgroundColor(AndroidColor.BLACK)
                        settings.javaScriptEnabled
                        settings.domStorageEnabled
                        webViewClient = WebViewClient()

                        settings.loadWithOverviewMode = true
                        settings.useWideViewPort = true
                        settings.setSupportZoom(true)
                    }
                },
                update = { webView ->
                    webView.loadUrl("https://img.etimg.com/thumb/msid-72948091,width-650,imgsize-95069,,resizemode-4,quality-100/star_istock.jpg")
                }
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "S: "+ star.size, maxLines = 1)
            Spacer(modifier = Modifier.height(1.dp))
            Text(text = "C: "+ star.color, maxLines = 1)
            Spacer(modifier = Modifier.height(1.dp))
            Text(text = "B: "+ star.brightness, maxLines = 2)
        }
    }

}