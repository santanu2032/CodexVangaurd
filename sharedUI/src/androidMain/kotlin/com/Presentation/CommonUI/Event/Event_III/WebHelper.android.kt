package com.Presentation.CommonUI.Event.Event_III

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
actual fun WebHelper(url: String, modifier: Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            WebView(context).apply {
                // Enable JavaScript (Optional but usually required for modern sites)
                settings.javaScriptEnabled = true

                // Forces the WebView to open links inside the app
                webViewClient = WebViewClient()

                loadUrl(url)
            }
        },
        update = { webView ->
            // This block runs every time the 'url' state changes
            webView.loadUrl(url)
        }
    )
}