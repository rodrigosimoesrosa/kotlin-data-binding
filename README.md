# Data binding for Kotlin

On this example I used two-way data binding for Android

Sample implementation on XML:

```xml
<data>
   <variable name="user" type="br.com.kotlin.databinding.data.User"/>
</data>
```

```xml
<EditText
    android:id="@+id/txtUser"
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:layout_marginEnd="16dp"
    android:layout_marginStart="16dp"
    android:layout_marginTop="16dp"
    android:text="@={user.name}"
    android:hint="@string/whats_your_name"
    app:layout_constraintHorizontal_bias="0.0"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```

Sample implementation on Kotlin object:

```kotlin
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


