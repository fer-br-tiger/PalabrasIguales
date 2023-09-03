package com.ferchu.palabrasiguales.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ferchu.palabrasiguales.R
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {}

    @After
    fun tearDown() {}

    @Test
    fun mainActivity_compareTexts() {
        Espresso.onView(
            ViewMatchers.withId(R.id.et_first_text)
        ).perform(
            ViewActions.typeText("Hola")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.et_second_text)
        ).perform(
            ViewActions.typeText("Hola")
        )

        Espresso.closeSoftKeyboard()

        Espresso.onView(
            ViewMatchers.withId(R.id.btn_compare)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.tv_result)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos son iguales.")
            )
        )
    }
}