package devx.raju.bottomnav.ui.main.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import devx.raju.bottomnav.ui.main.NumData

class NotificationsViewModel : ViewModel() {

   private var numList  = arrayListOf<NumData>()
    private val _num = MutableLiveData<List<NumData>>()
    val num: LiveData<List<NumData>> = _num

 private val _secLargNum = MutableLiveData<Int>()
    val secLargNum: LiveData<Int> = _secLargNum

    fun add(n:Int){
        numList.add(NumData(n))
        _num.postValue(numList)
    }

    fun update(n:Int){
        _secLargNum.postValue(n)
    }

    fun updateUI() {
        if(numList.isNotEmpty()){
            _num.postValue(numList)
        }
        if(_secLargNum.value!=null){
            _secLargNum.postValue(_secLargNum.value)
        }
    }

}