import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.junit.Rule
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.domain.TimeConfiguration
import com.domain.firebase_db.RemoteNotesDataSource


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    // 1. Initialize the Compose test rule
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testAssistantInterface() {
        // 2. Wrap your Composable inside setContent
        composeTestRule.setContent {

        }

    }
}
@Preview
@Composable
fun userUI(){

    Box(modifier = Modifier
        .fillMaxSize()
    ){


        Column(modifier = Modifier){
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.05f)
                .background(color = Color(0xFF673AB7))
                .align(Alignment.Start),
                contentAlignment = Alignment.Center
            ){
                Box(modifier = Modifier
                    .fillMaxWidth(0.1f)
                    .fillMaxHeight()
                    .background(color = Color(0xFF673AB7))
                    .clickable{}
                    .align(Alignment.TopStart),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "<", color = Color.White)
                }
                Text(text = "NOTICE")
            }
            Row(modifier = Modifier){

            }
            Row(modifier = Modifier){

            }
        }
    }
}