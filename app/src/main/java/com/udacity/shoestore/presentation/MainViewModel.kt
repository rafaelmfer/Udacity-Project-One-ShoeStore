package com.udacity.shoestore.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewModel : ViewModel() {

    private val _shoeListMutableLiveData = MutableLiveData<MutableList<Shoe>>()
    val shoeListLiveData: LiveData<MutableList<Shoe>> get() = _shoeListMutableLiveData

    private val _shoeName = MutableLiveData<String>()
    val shoeName: LiveData<String> get() = _shoeName

    private val _shoeCompany = MutableLiveData<String>()
    val shoeCompany: LiveData<String> get() = _shoeCompany

    private val _shoeSize = MutableLiveData<String>()
    val shoeSize: LiveData<String> get() = _shoeSize

    private val _shoeDescription = MutableLiveData<String>()
    val shoeDescription: LiveData<String> get() = _shoeDescription

    private val shoeList = mutableListOf<Shoe>()

    fun addShoe() {
        if (!shoeName.value.isNullOrBlank() && !shoeCompany.value.isNullOrBlank() && !shoeSize.value.isNullOrBlank() && !shoeDescription.value.isNullOrBlank()) {
            val shoe = Shoe(
                name = shoeName.value!!,
                size = shoeSize.value!!.toDouble(),
                company = shoeCompany.value!!,
                description = shoeDescription.value!!
            )
            shoeList.add(shoe)
        }
        _shoeListMutableLiveData.postValue(shoeList)
    }
}