package br.com.kotlin.databinding.data

import android.databinding.BaseObservable
import android.databinding.Bindable
import br.com.kotlin.databinding.BR
import java.io.Serializable

/**
 * Created by rodrigosimoesrosa
 */
class User : BaseObservable(), Serializable {

    companion object {
        fun build (name:String, nationality: String): User {
            val user = User()
            user.name = name
            user.nationality = nationality

            return user
        }
    }

    @Bindable
    var name: String = String()
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }
        get() = field

    @Bindable
    var nationality: String = String()
        set(value) {
            field = value
            notifyPropertyChanged(BR.nationality)
        }
        get() = field
}