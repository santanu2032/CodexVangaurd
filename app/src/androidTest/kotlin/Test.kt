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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



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







data class ActionCardModel(
    val title: String,
    val description: String,
    val themeColor: Color,
    val topLabel: String,
    val actionText: String,
    val bottomLeftText: String,
    val progress: Float? = null
)

@Composable
fun StudyActionCard(model: ActionCardModel) {

    Card(
        modifier = Modifier.fillMaxSize(), // Now takes the size dictated by PrototypeBox
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF191C24))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawBehind {
                    drawCircle(
                        color = model.themeColor.copy(alpha = 0.15f),
                        radius = size.width * 0.45f,
                        center = Offset(size.width, 0f)
                    )
                }
                .padding(24.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(model.themeColor.copy(alpha = 0.2f), RoundedCornerShape(12.dp))
                    )
                    Text(
                        text = model.topLabel,
                        color = model.themeColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .background(model.themeColor.copy(alpha = 0.15f), RoundedCornerShape(16.dp))
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = model.title, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = model.description, color = Color(0xFF8B92A5), fontSize = 14.sp, lineHeight = 20.sp)

                Spacer(modifier = Modifier.weight(1f))

                if (model.progress != null) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Weekly goal", color = Color(0xFF8B92A5), fontSize = 12.sp)
                        Text("${(model.progress * 100).toInt()}%", color = model.themeColor, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    LinearProgressIndicator(
                        progress = { model.progress },
                        modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(3.dp)),
                        color = model.themeColor,
                        trackColor = Color(0xFF262A36)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = model.bottomLeftText, color = Color(0xFF8B92A5), fontSize = 12.sp)
                    Text(text = "${model.actionText} ↗", color = model.themeColor, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun NavigationBar(){
    Box(modifier = Modifier.fillMaxSize()) {


        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .zIndex(1f)
                .padding(horizontal = 24.dp, vertical = 24.dp)
                .fillMaxWidth()
                .height(76.dp)
                .background(color = Color(0xFF191C24), shape = RoundedCornerShape(24.dp))
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFF635688).copy(alpha = 0.3f), RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("⊞", color = Color.White, fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Dashboard", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                }
            }


            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("📅", color = Color(0xFF8B92A5), fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Study plan", color = Color(0xFF8B92A5), fontSize = 12.sp)
                }
            }


            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("📚", color = Color(0xFF8B92A5), fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Library", color = Color(0xFF8B92A5), fontSize = 12.sp)
                }
            }
        }
    }
}



@Composable
fun InputContainer(){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Transparent)
        .zIndex(1f)
    ){

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

@Preview
@Composable
fun InputContainer(
    modifier: Modifier = Modifier,
    onMicClick: () -> Unit = {},
    onSendClick: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }

    // Outer container with transparent background
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(16.dp)
    ) {
        // Dark, rounded input bar with shadow
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 4.dp, shape = CircleShape)
                .background(color = Color(0xFF2C2C2C), shape = CircleShape)
                .padding(horizontal = 8.dp, vertical = 6.dp)
        ) {

            // Unstyled text field area
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
                            // Optional placeholder logic can go here
                        }
                        innerTextField()
                    }
                }
            )

            // Circular Purple Action Buttons
            val purpleColor = Color(0xFF6750A4)

            IconButton(
                onClick = onMicClick,
                colors = IconButtonDefaults.iconButtonColors(containerColor = purpleColor),
                modifier = Modifier.size(40.dp)
            ) {
                // TODO: Add Mic Icon
            }

            Spacer(modifier = Modifier.width(6.dp))

            IconButton(
                onClick = {
                    if (text.isNotBlank()) {
                        onSendClick(text)
                        text = ""
                    }
                },
                colors = IconButtonDefaults.iconButtonColors(containerColor = purpleColor),
                modifier = Modifier.size(40.dp)
            ) {
                // TODO: Add Send Icon
            }
        }
    }
}