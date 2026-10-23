package com.Presentation.CommonUI.Event.Event_II

import com.domain.AI.Output.SpeechEngine
import com.domain.AI.UserInput.AiSpecialist
import com.domain.AI.UserInput.ContextType
import com.domain.AI.EchoSpecialist
import com.domain.AI.UserInput.UserInputContract

class DesktopPlatformDependencies : PlatformDependencies {
    override fun createSpeechEngine(): SpeechEngine = DesktopSpeechEngine()
    override fun createAiSpecialists(): List<AiSpecialist> = listOf(
        EchoSpecialist(ContextType.GENERAL)
    )
    override fun createUserInputContract(): UserInputContract = /* desktop impl */ TODO()
}

//TODO I have to add this to windowsMain
/*
fun main() = application {
    val container = remember { AppContainer(DesktopPlatformDependencies()) }

    Window(onCloseRequest = {
        container.release()
        exitApplication()
    }, title = "Alpha") {
        MainScreen(
            obj3 = container.userInputContract,
            intentManager = container.intentManager,
            speech = container.speechOutput
        )
    }
}*/