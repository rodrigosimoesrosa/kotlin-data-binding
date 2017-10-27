package br.com.kotlin.databinding.base

import android.app.Activity
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

/**
 * Created by rodrigosimoesrosa
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
abstract class AcceptanceActivityTest<T : Activity>(clazz: Class<T>) {

    @Rule
    @JvmField
    val activityRule: ActivityTestRule<T> = buildRule(clazz)

    abstract fun buildRule(clazz: Class<T>) : ActivityTestRule<T>

    @Before
    fun setActivity() {
        activity = activityRule.activity
    }

    var activity : T? = null
    val check: Matchers = Matchers()
    val event: Events = Events()
}
