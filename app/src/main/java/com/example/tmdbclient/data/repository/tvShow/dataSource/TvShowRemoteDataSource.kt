package com.example.tmdbclient.data.repository.tvShow.dataSource

import com.example.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response


interface TvShowRemoteDataSource {

    suspend fun getTvShows(): Response<TvShowList>
}