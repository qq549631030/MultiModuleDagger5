package cn.hx.user

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    val set: Set<String>
) : ViewModel() {

    var data: String
        get() = savedStateHandle.get<String>("data") ?: "hello"
        set(value) {
            savedStateHandle.set("data", value)
        }
}