package com.Presentation.CommonUI.mainScreenUI
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


import androidx.compose.ui.unit.dp
import com.Presentation.CommonUI.mainScreenUI.LocalDomain.LocalManager
import com.Presentation.CommonUI.values.ActionCardModel
import com.Presentation.CommonUI.values.StudyActionCard


@Composable
fun PrototypeBox_I(manager: LocalManager){
    var isClicked by remember { mutableStateOf(false) }
    val boxColor = if (isClicked) Color.Gray else Color.White


    Box(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier

            .fillMaxWidth(0.4f)
            .fillMaxHeight(0.2f)
            .background(color = boxColor, shape = RoundedCornerShape(30.dp))
            .align(BiasAlignment(horizontalBias = -0.8f, verticalBias = -0.35f))
            .clickable {
                isClicked = !isClicked
                try {
                    manager.Clicked_1()
                }
                catch (e: Exception) {
                    System.err.println(e)
                    e.printStackTrace()
                }
            }
        ) { StudyActionCard(
            model = ActionCardModel(//TODO replace with variable
                title = "Continue learning",
                description = "Return to Cellular Respiration and pick up at the electron transport chain.",
                themeColor = Color(0xFF635688), // Purple theme
                topLabel = "Biology 201",
                actionText = "Resume lesson",
                bottomLeftText = "18 min left",
                progress = 0.68f
            )
        ) }
    }
}
