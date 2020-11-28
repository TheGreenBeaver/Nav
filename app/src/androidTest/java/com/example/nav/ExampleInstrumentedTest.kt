package com.example.nav

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
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


    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.nav", appContext.packageName)
    }

    @Test
    fun straightForward() {
        onView(withId(R.id.first_to_second_btn)).perform(click())
        onView(withId(R.id.second_to_third_btn)).check(matches(isDisplayed()))

        onView(withId(R.id.second_to_third_btn)).perform(click())
        onView(withId(R.id.third_to_second_btn)).check(matches(isDisplayed()))

        onView(withId(R.id.third_to_second_btn)).perform(click())
        onView(withId(R.id.second_to_third_btn)).check(matches(isDisplayed()))

        onView(withId(R.id.second_to_third_btn)).perform(click())
        onView(withId(R.id.third_to_first_btn)).check(matches(isDisplayed()))

        onView(withId(R.id.third_to_first_btn)).perform(click())
        onView(withId(R.id.first_to_second_btn)).check(matches(isDisplayed()))

        onView(withId(R.id.first_to_second_btn)).perform(click())
        onView(withId(R.id.second_to_third_btn)).check(matches(isDisplayed()))

        onView(withId(R.id.second_to_third_btn)).perform(click())
        onView(withId(R.id.third_to_second_btn)).check(matches(isDisplayed()))

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
        // 1 => about => 1
        onView(withId(R.id.navigation_about)).perform(click())
        onView(withId(R.id.about_text)).check(matches(isDisplayed()))
        Espresso.pressBack()
        onView(withId(R.id.first_to_second_btn)).check(matches(isDisplayed()))

        // 1 => 2
        onView(withId(R.id.first_to_second_btn)).perform(click())
        onView(withId(R.id.second_to_third_btn)).check(matches(isDisplayed()))

        // 2 => about => 2
        onView(withId(R.id.navigation_about)).perform(click())
        onView(withId(R.id.about_text)).check(matches(isDisplayed()))
        Espresso.pressBack()
        onView(withId(R.id.second_to_third_btn)).check(matches(isDisplayed()))

        // 2 => 3
        onView(withId(R.id.second_to_third_btn)).perform(click())
        onView(withId(R.id.third_to_first_btn)).check(matches(isDisplayed()))

        // 3 => about => 3
        onView(withId(R.id.navigation_about)).perform(click())
        onView(withId(R.id.about_text)).check(matches(isDisplayed()))
        Espresso.pressBack()
        onView(withId(R.id.third_to_first_btn)).check(matches(isDisplayed()))

        // Check that About is not in the backStack and its size is still 3
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
}