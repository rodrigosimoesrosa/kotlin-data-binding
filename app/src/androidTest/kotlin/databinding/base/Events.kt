package br.com.kotlin.databinding.base

import android.support.annotation.IdRes
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewAction
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matchers.allOf

class Events {

    fun eventOnView(@IdRes viewId: Int, vararg actions: ViewAction): ViewInteraction? {
        return onView(allOf(isDisplayed(), withId (viewId))).perform(*actions)
    }
}
