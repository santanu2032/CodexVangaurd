import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
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
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.contentType
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.Presentation.CommonUI.Event.EventStatus
import com.Presentation.CommonUI.Event.Event_II.Event_2
import com.Presentation.CommonUI.Event.Event_II.TextField_event_2
import com.Presentation.CommonUI.values.CustomColorKT
import com.Presentation.CommonUI.values.SantanuCC
import org.junit.Rule
import java.nio.file.WatchEvent


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



@Composable
fun InputContainer(){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)){//TODO    (change to TRANSPARENT)

        Row(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.08f)
            .align(Alignment.BottomCenter)
            .background(Color.Red, shape = RoundedCornerShape(24.dp)),
            horizontalArrangement = Arrangement.spacedBy(2.dp, alignment = Alignment.End),//TODO    (change tHE COLOR UX OPERATION)
            verticalAlignment = Alignment.CenterVertically){


            Box(modifier = Modifier
                .padding(end = 5.dp, start = 3.dp, top = 3.dp, bottom = 3.dp)
                .width(285.dp)
                .fillMaxHeight()
                .clip(CircleShape)
                .background(Color.Green)//TODO    (change THE COLOR UX OPERATION)
            ){

                TextField_event_2()
            }

            Box(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .width(30.dp)
                    .height(40.dp)
                    .clip(CircleShape)

                    .background(color = Color.White)
                    .clickable{
                        TODO("link the manager")
                    },
                contentAlignment = Alignment.Center) {
                Text(text = "A") }
            Box(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .width(30.dp)
                    .height(40.dp)
                    .clip(CircleShape)

                    .background(color = Color.White)
                    .clickable{
                        TODO("link the manager")
                    },
                contentAlignment = Alignment.Center
            )
            {
                Text(text = "A")
            }




        }

    }

}
//@Preview
@Composable
fun Output() {

    var dummy by remember { mutableStateOf("test") }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        .zIndex(0f)

    ) {

        TextField(value = dummy, onValueChange = { dummy = it },
            modifier = Modifier
            .fillMaxSize()
                .align(Alignment.Center),
            textStyle = TextStyle(color = Color.White, textAlign = TextAlign.Center),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}
@Preview
@Composable
fun Network_UI(){
Box(modifier = Modifier

    .fillMaxSize()
    .background(color = Color.Black)

) {

    Box(modifier = Modifier
        .fillMaxWidth(0.9f)
        .fillMaxHeight(0.2f)
        .background(color = Color.Red)//TODO("change it to mutable or remote calling")
        .align(alignment = BiasAlignment(horizontalBias = 0.1f, verticalBias = -0.96f))
        .padding(all = 20.dp),
        contentAlignment = Alignment.Center,


    ){Text("Status")}
    Box(modifier = Modifier
        .fillMaxHeight(0.08f)
        .fillMaxWidth(0.3f)
        .align(alignment = Alignment.Center)
        .background(color = Color.White),
        contentAlignment = Alignment.Center

    ) {
        Text("Test run")
    }

}
}
