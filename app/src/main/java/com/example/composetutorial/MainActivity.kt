package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
private fun App (){
    ComposeKijiImage(
        title = stringResource(R.string.title_text),
        body = stringResource(R.string.body_text),
        botm = stringResource(R.string.botmn_text),
        image = painterResource(R.drawable.bg_compose_background)
    )
}
@Composable
fun ComposeKijiImage(title: String, body: String, botm: String, image: Painter) {
    Column {
        // 画面いっぱい
        Image(
            painter = image, contentDescription = null
        )
        Text(
            // フォントサイズ 24sp、パディング（上下左右）16dp
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
                .wrapContentWidth(align = Alignment.Start)
        )

        Text(
            // デフォルトのフォントサイズ、パディング（左右）16dp、テキスト配置 Justify
            text = body,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .wrapContentWidth(),
            textAlign = TextAlign.Justify
        )
        Text(
            // デフォルトのフォントサイズ、パディング（上下左右）16dp、テキスト配置 Justify
            text = botm,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ComposeKijiPreview() {
    ComposeTutorialTheme {
        App()
    }
}