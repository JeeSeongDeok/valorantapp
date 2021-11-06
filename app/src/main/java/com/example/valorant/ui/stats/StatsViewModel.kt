package com.example.valorant.ui.stats

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorant.domain.use_case.GetStatsUseCase
import com.example.valorant.utils.Constants
import com.example.valorant.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StatsViewModel @Inject constructor(
    private val getStatsUseCase: GetStatsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf<StatsState>(StatsState())
    val state: State<StatsState> = _state

    init{
        savedStateHandle.get<String>(Constants.PARAM_UID)?.let { uid->
            getStat(uid)
        }
    }

    private fun getStat(uid: String){
        getStatsUseCase(uid).onEach { result->
            when(result){
                is Resource.Success -> {
                    _state.value = StatsState(stats = result.data)
                }
                is Resource.Error -> {
                    _state.value = StatsState(error = result.message ?: "예상하지 못한 에러")
                }
                is Resource.Loading ->{
                    _state.value = StatsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}

// 이전 소스
//open class StatsViewModel : ViewModel() {
//    // repository
//    private val matchRepository by lazy{
//        MatchRepositoryImpl()
//    }
//    // 통신에서 받을 데이터를 LiveData로 설정
//    private var _mmrLiveData = MutableLiveData<List<matchList>>()
//    val mmrLiveData: LiveData<List<matchList>>
//        get() = _mmrLiveData
//    // Progressbar 설정
//    private val _isLoading = MutableLiveData<Boolean>()
//    val isLoading: MutableLiveData<Boolean>
//        get() = _isLoading
//    init{
//        _isLoading.value = false
//        _mmrLiveData = matchRepository.playerMatchData
//    }
//    // API 연결
//    fun getMMR(){
//
//        // 프로그래스바 실행
//        doLoading()
//
//
//        doneLoading()
//    }
//    private fun doLoading(){
//        _isLoading.value = true
//    }
//    private fun doneLoading(){
//        _isLoading.value = false
//    }
//}