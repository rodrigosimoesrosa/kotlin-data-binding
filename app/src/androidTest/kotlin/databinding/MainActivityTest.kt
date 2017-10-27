package databinding

import android.support.test.espresso.action.ViewActions
import android.support.test.rule.ActivityTestRule
import br.com.kotlin.databinding.MainActivity
import br.com.kotlin.databinding.R
import br.com.kotlin.databinding.base.AcceptanceActivityTest
import org.junit.Test

/**
 * Created by rodrigosimoesrosa
 */
class MainActivityTest: AcceptanceActivityTest<MainActivity>(MainActivity::class.java) {

    override fun buildRule(clazz: Class<MainActivity>): ActivityTestRule<MainActivity> = ActivityTestRule(clazz)

    private val rightNameValue = "Nikola Tesla"
    private val rightNationality = "Austrian"

    @Test
    fun inputCorrectValues() {
        event.eventOnView(R.id.txtUser,
                ViewActions.click(),
                ViewActions.clearText(),
                ViewActions.typeText(rightNameValue))
        event.eventOnView(R.id.txtNationality,
                ViewActions.click(),
                ViewActions.clearText(),
                ViewActions.replaceText(rightNationality))
    }

    @Test
    fun replaceCorrectValues() {
        event.eventOnView(R.id.txtUser,
                ViewActions.click(),
                ViewActions.replaceText(rightNameValue))
        event.eventOnView(R.id.txtNationality,
                ViewActions.click(),
                ViewActions.replaceText(rightNationality))
    }
}