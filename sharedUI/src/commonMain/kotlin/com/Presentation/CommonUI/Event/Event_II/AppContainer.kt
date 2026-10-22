package com.Presentation.CommonUI.Event.Event_II

import com.domain.AI.Output.SpeechEngine
import com.domain.AI.Output.SpeechOutputController
import com.domain.AI.UserInput.ContextClassifier
import com.domain.AI.UserInput.IntentManager
import com.domain.AI.UserInput.KeywordContextClassifier
import com.domain.AI.UserInput.UserInputContract


class AppContainer(platform: PlatformDependencies) {


    val classifier: ContextClassifier = KeywordContextClassifier()

    val intentManager: IntentManager = IntentManager(
        classifier = classifier,
        specialists = platform.createAiSpecialists()
    )


    private val speechEngine: SpeechEngine = platform.createSpeechEngine()
    val speechOutput: SpeechOutputController = SpeechOutputController(speechEngine)


    val userInputContract: UserInputContract = platform.createUserInputContract()

    fun release() {
        speechOutput.release()
    }
}