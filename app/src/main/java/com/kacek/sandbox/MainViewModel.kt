package com.kacek.sandbox

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    /* When [Enable K2 Kotlin mode] option in Android Studio will be more stable
     * then we will be able to use the following syntax:
     *
     *  val isAppReady: StateFlow<Boolean>
     *      field = MutableStateFlow(false)
     *
     * https://github.com/Kotlin/KEEP/blob/explicit-backing-fields-re/proposals/explicit-backing-fields.md
     */
    private val _isAppReady = MutableStateFlow(false)
    val isAppReady = _isAppReady.asStateFlow()

    init {
        viewModelScope.launch {
            delay(1000)
            _isAppReady.value = true
        }
    }
}
