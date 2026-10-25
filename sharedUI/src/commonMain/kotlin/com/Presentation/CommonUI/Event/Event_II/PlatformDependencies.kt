package com.Presentation.CommonUI.Event.Event_II

import com.domain.AI.Output.SpeechEngine
import com.domain.AI.UserInput.AiSpecialist
import com.domain.AI.UserInput.UserInputContract


interface PlatformDependencies {
    fun createSpeechEngine(): SpeechEngine
    fun createAiSpecialists(): List<AiSpecialist>
    fun createUserInputContract(): UserInputContract
}