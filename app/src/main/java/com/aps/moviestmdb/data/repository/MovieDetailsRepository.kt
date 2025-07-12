package com.aps.moviestmdb.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.aps.moviestmdb.data.paging.MoviePagingSource
import com.aps.moviestmdb.data.remote.ApiService
import com.aps.moviestmdb.data.remote.response.MovieDetailsDTO
import com.aps.moviestmdb.data.remote.response.MovieResponse
import com.aps.moviestmdb.data.models.Movies
import com.ericg.neatflix.data.remote.response.CastResponse
import com.ericg.neatflix.data.remote.response.GenreResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieDetailsRepository @Inject constructor(private val apiService: ApiService) {


    fun getMoviesDetailsRepo(movieId: String): Flow<MovieDetailsDTO> = flow {
        val response = apiService.getMoviesDetails(movieId.toInt())
        emit(response)
    }.flowOn(Dispatchers.IO)


    fun getCastMoviesRepo(movieId: String): Flow<CastResponse> = flow {
        val response = apiService.getMovieCast(movieId.toInt())
        emit(response)
    }.flowOn(Dispatchers.IO)

    fun getSimilarMoviesRepo(movieId: String): Flow<MovieResponse> = flow {
        val response = apiService.getSimilarMovies(movieId.toInt())
        emit(response)
    }.flowOn(Dispatchers.IO)

}
