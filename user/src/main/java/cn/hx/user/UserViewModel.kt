package cn.hx.user

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class UserViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    val set: Set<String>
) : ViewModel() {

    var data: String
        get() = savedStateHandle.get<String>("data") ?: "hello"
        set(value) {
            savedStateHandle.set("data", value)
        }
}