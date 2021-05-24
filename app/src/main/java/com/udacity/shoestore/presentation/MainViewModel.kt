package com.udacity.shoestore.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewModel : ViewModel() {

    private val _shoeListMutableLiveData = MutableLiveData<MutableList<Shoe>>()
    val shoeListLiveData: LiveData<MutableList<Shoe>> get() = _shoeListMutableLiveData

    val shoeName = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val shoeDescription = MutableLiveData<String>()

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