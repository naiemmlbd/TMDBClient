package com.example.tmdbclient.data.repository

import android.util.Log
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.example.tmdbclient.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.tmdbclient.domain.repository.TvShowRepo


class TvShowRepoImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepo {
    override suspend fun getTvShows(): List<TvShow>? {

        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {

        val newTvShowList = getTvShowFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newTvShowList)
        tvShowCacheDataSource.saveTvShowsToCache(newTvShowList)

        return newTvShowList
    }


    suspend fun getTvShowFromApi(): List<TvShow> {
        var tvShowList: List<TvShow> = ArrayList<TvShow>()

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return tvShowList
    }

    suspend fun getTvShowFromDB():List<TvShow>{

        var tvShowList: List<TvShow> = ArrayList<TvShow>()

        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()

        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = getTvShowFromApi()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTvShowFromCache(): List<TvShow>{
        var tvShowList: List<TvShow> = ArrayList<TvShow>()

        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()

        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = getTvShowFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }

        return tvShowList
    }


}