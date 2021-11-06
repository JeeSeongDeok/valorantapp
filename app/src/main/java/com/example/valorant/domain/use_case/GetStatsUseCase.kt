package com.example.valorant.domain.use_case

import com.example.valorant.domain.reposiotry.HenrikDevRepository
import com.example.valorant.model.matchData
import com.example.valorant.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetStatsUseCase @Inject constructor(
    private val repository: HenrikDevRepository
) {
    operator fun invoke(uid: String): Flow<Resource<List<matchData>>> = flow{
        try{
            emit(Resource.Loading<List<matchData>>())
            val stats = repository.getStats(uid)
            emit(Resource.Success(stats))
        } catch (e: HttpException) {
            emit(Resource.Error<List<matchData>>(e.message()?: "예상치 못한 오류"))
        } catch (e: IOException) {
            emit(Resource.Error<List<matchData>>("인터넷 연결 문제"))
        }
    }
}