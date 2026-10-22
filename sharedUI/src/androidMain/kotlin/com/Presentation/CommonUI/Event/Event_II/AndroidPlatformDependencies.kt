package com.Presentation.CommonUI.Event.Event_II

import android.content.Context
import com.domain.AI.Output.SpeechEngine
import com.domain.AI.UserInput.ContextType
import com.domain.AI.EchoSpecialist
import com.domain.AI.GeneralSpecialistAI
import com.domain.AI.UserInput.AiSpecialist
import com.domain.AI.UserInput.UserInputContract

class AndroidPlatformDependencies(private val context: Context) : PlatformDependencies {

    override fun createSpeechEngine(): SpeechEngine = AndroidSpeechEngine(context)

    override fun createAiSpecialists(): List<AiSpecialist> = listOf(
        // TODO Swap these for real adapters later
        EchoSpecialist(ContextType.CODING),
        EchoSpecialist(ContextType.MATH),
        GeneralSpecialistAI(ContextType.GENERAL)
    )

    override fun createUserInputContract(): UserInputContract =
        InputStateHolder()
}

