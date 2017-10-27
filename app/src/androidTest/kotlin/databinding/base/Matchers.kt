package br.com.kotlin.databinding.base

import android.app.Activity
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.doesNotExist
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.matcher.ViewMatchers.*

class Matchers {

    fun viewExist(@IdRes viewId: Int){
        onView(withId(viewId)).check(doesNotExist())
    }

    fun viewDisplayed(@IdRes viewId: Int){
        onView(withId(viewId)).check(matches(isDisplayed()))
    }

    fun <T:Activity> nextActivityWhichWillOpenIs(clazz: Class<T>) {
        intended(IntentMatchers.hasComponent(clazz.name))
    }

    fun viewIsVisibleAndContainsText(@StringRes stringResource: Int) {
        onView(withText(stringResource)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    fun viewContainsText(@IdRes viewId: Int, @StringRes stringResource: Int) {
        onView(withId(viewId)).check(matches(withText(stringResource)))
    }
}


