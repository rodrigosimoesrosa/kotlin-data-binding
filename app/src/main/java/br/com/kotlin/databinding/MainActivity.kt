package br.com.kotlin.databinding

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.kotlin.databinding.data.User
import br.com.kotlin.databinding.databinding.ActivityMainBinding


/**
 * Created by rodrigosimoesrosa
 */
class MainActivity : AppCompatActivity() {

    private val USER: String = "USER"
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user = savedInstanceState?.getSerializable(USER) as User? ?: User.build("Rodrigo", "Brazil")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.user = user
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(USER, user)
    }
}
