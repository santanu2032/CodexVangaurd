import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import androidx.compose.foundation.background
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
fun StatusBar() {//TODO("pass obj for currentState")

    Box(modifier = Modifier.fillMaxSize()) {


        Row(
            modifier = Modifier
                .fillMaxWidth(0.94f)
                .fillMaxHeight(0.15f)
                .align(BiasAlignment(horizontalBias = 0f, verticalBias = -0.96f))
                .padding(horizontal = 16.dp, vertical = 16.dp), // Reduced from 50.dp to prevent layout crush
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "LET'S STUDY",
                        color = Color(0xFF635688),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Focus mode",
                        color = Color(0xFF28565A),
                        fontSize = 11.sp,
                        modifier = Modifier
                            .background(Color(0xFF28565A).copy(alpha = 0.2f), RoundedCornerShape(12.dp))
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = ", Maya",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color(0xFF262A36), RoundedCornerShape(20.dp))
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    Text("🔥", fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("12 day streak", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                }


                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFF262A36), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🔔", fontSize = 14.sp)
                }

                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFF635688), CircleShape)
                )
            }
        }
    }
}