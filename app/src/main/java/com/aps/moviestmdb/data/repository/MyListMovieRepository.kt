package com.aps.moviestmdb.data.repository


import com.aps.moviestmdb.data.local.MovieDao
import com.aps.moviestmdb.data.local.WatchListModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MyListMovieRepository @Inject constructor(private val movieDao: MovieDao) {
    suspend fun insertMovieInList(myListMovie: WatchListModel) {
        movieDao.insertMovieInList( myListMovie)
    }

    suspend fun removeFromList(mediaId: Int) {
        movieDao.removeFromList(mediaId)
    }

    suspend fun deleteList() {
        movieDao.deleteList()
    }

    suspend fun exist(mediaId: Int): Int {
        return movieDao.exists(mediaId)
    }

    fun getAllData(): Flow<List<WatchListModel>> {
        return movieDao.getAllWatchListData()
    }
}