package com.udacity.shoestore.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewModel : ViewModel() {

    private val _shoeListMutableLiveData = MutableLiveData<MutableList<Shoe>>()
    val shoeListLiveData: LiveData<MutableList<Shoe>> get() = _shoeListMutableLiveData

    private val _eventCancelMutableLiveData = MutableLiveData<Boolean>()
    val eventCancelLiveData: LiveData<Boolean> get() = _eventCancelMutableLiveData

    private val _eventAddShoeMutableLiveData = MutableLiveData<Boolean>()
    val eventAddShoeLiveData: LiveData<Boolean> get() = _eventAddShoeMutableLiveData

    var shoeName = MutableLiveData<String>()
    var shoeCompany = MutableLiveData<String>()
    var shoeSize = MutableLiveData<String>()
    var shoeDescription = MutableLiveData<String>()

    private val shoeList = mutableListOf<Shoe>()

    init {
        _eventCancelMutableLiveData.value = false
        _eventAddShoeMutableLiveData.value = false
    }

    fun addShoe() {
        if (!shoeName.value.isNullOrBlank() && !shoeCompany.value.isNullOrBlank() && !shoeSize.value.isNullOrBlank() && !shoeDescription.value.isNullOrBlank()) {
            val shoe = Shoe(
                name = shoeName.value!!,
                size = shoeSize.value!!.toDouble(),
                company = shoeCompany.value!!,
                description = shoeDescription.value!!
            )
            shoeList.add(shoe)
            _shoeListMutableLiveData.postValue(shoeList)
            _eventAddShoeMutableLiveData.value = true
        }
    }

    fun onCancel() {
        _eventCancelMutableLiveData.value = true
    }

    fun onAddShoeComplete() {
        _eventAddShoeMutableLiveData.value = false
        shoeName = MutableLiveData<String>()
        shoeCompany = MutableLiveData<String>()
        shoeSize = MutableLiveData<String>()
        shoeDescription = MutableLiveData<String>()
    }

    fun onCancelEventComplete() {
        _eventCancelMutableLiveData.value = false
    }
}