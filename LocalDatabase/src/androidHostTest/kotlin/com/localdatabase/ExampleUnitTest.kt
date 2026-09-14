package com.localdatabase

import org.junit.Assert.fail
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

        try {
            execute()
            // assertTrue(someCondition)
            println("Test running successfully on the local JVM!")
        } catch (e: Exception) {
            fail("Database test crashed: ${e.message}")
        }
    }
}