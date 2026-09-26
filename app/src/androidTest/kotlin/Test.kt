import androidx.compose.foundation.Image
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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*

import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import testui.sharedui.generated.resources.Res
import testui.sharedui.generated.resources.login_bg


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
fun LoginUi(){

    var text by remember { mutableStateOf("") }
    Box(modifier = Modifier
        .fillMaxSize()
        .background( Color.Black)) {

        Image(
            painter = painterResource(Res.drawable.login_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(modifier = Modifier
            .fillMaxWidth(0.8f)
            .fillMaxHeight(0.5f)
            .background(Color.White, shape = RoundedCornerShape(60.dp))
            .align(BiasAlignment(horizontalBias = 0f, verticalBias = 0f))
            .padding(top = 16.dp),
            contentAlignment = Alignment.TopCenter
        ){

            Text(text = "LOGIN",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold)
            Row(modifier = Modifier
                .fillMaxWidth(0.78f)
                .align(BiasAlignment(horizontalBias = 0f, verticalBias = -0.7f))
                .shadow(elevation = 4.dp, shape = CircleShape)
                .background(color = Color(0xFF2C2C2C), shape = CircleShape)
                .padding(horizontal = 8.dp, vertical = 6.dp)) {
                BasicTextField(
                    value = text,
                    onValueChange = { text = it },
                    textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
                    cursorBrush = SolidColor(Color.White),
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp),
                    decorationBox = { innerTextField ->
                        Box(contentAlignment = Alignment.CenterStart) {
                            if (text.isEmpty()) {
                                Text("Enter user id")
                            }
                            innerTextField()
                        }
                    }
                )

            }
            Spacer(modifier = Modifier.height(32.dp))
            Row(modifier = Modifier
                .fillMaxWidth(0.78f)
                .align(BiasAlignment(horizontalBias = 0f, verticalBias = -0.5f))
                .shadow(elevation = 4.dp, shape = CircleShape)
                .background(color = Color(0xFF2C2C2C), shape = CircleShape)
                .padding(horizontal = 8.dp, vertical = 6.dp)) {
                BasicTextField(
                    value = text,
                    onValueChange = { text = it },
                    textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
                    cursorBrush = SolidColor(Color.White),
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp),
                    decorationBox = { innerTextField ->
                        Box(contentAlignment = Alignment.CenterStart) {
                            if (text.isEmpty()) {
                                Text("Enter Password")
                            }
                            innerTextField()
                        }
                    }
                )

            }
            Box(modifier = Modifier
                .fillMaxHeight(0.1f)
                .fillMaxWidth(0.2f)
                .background(Color.Gray, shape = RoundedCornerShape(16.dp))
                .align(BiasAlignment(horizontalBias = 0f, verticalBias = 0f)),
                contentAlignment = Alignment.Center
            ){
                Text("Login")
            }
        }


    }
}