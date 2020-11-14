package com.example.nav

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val testRule = ActivityScenarioRule<ActivityOne>(ActivityOne::class.java)

    @Before
    fun beforeEach() {
        Intents.init()
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.nav", appContext.packageName)
    }

    @Test
    fun straightForward() {
        onView(withId(R.id.first_to_second_btn)).perform(click())
        intended(hasComponent(hasShortClassName(".ActivityTwo")))
        onView(withId(R.id.second_to_third_btn)).perform(click())
        intended(hasComponent(hasShortClassName(".ActivityThree")))

        var isFinished = false
        var stackSize = 0
        while (!isFinished) {
            Espresso.pressBackUnconditionally()
            stackSize++
            testRule.scenario.onActivity { activity ->
                isFinished = activity.isFinishing
            }
        }

        assertEquals(3, stackSize)
    }

    @Test
    fun seeAboutFromAnywhere() {
        onView(withId(R.id.navigation_about)).perform(click())
        intended(hasComponent(hasShortClassName(".ActivityAbout")))

        Espresso.pressBack()
        onView(withId(R.id.first_to_second_btn)).check(matches(isDisplayed()))

        onView(withId(R.id.first_to_second_btn)).perform(click())
        intended(hasComponent(hasShortClassName(".ActivityTwo")))

        onView(withId(R.id.navigation_about)).perform(click())
        intended(hasComponent(hasShortClassName(".ActivityAbout")))
        Espresso.pressBack()
        onView(withId(R.id.second_to_third_btn)).check(matches(isDisplayed()))
        onView(withId(R.id.second_to_third_btn)).perform(click())
        intended(hasComponent(hasShortClassName(".ActivityThree")))
        onView(withId(R.id.navigation_about)).perform(click())
        intended(hasComponent(hasShortClassName(".ActivityAbout")))
    }
}