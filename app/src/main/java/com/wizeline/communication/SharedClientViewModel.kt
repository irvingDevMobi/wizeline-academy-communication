package com.wizeline.communication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedClientViewModel : ViewModel() {

    private val _uiState = MutableLiveData<Client>()
    val uiState: LiveData<Client> get() = _uiState

    fun updateUiState(client: Client) {
        _uiState.value = client
    }
}
