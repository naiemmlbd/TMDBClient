package com.example.tmdbclient.data.repository.tvShow.dataSourceImpl

import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.data.repository.artist.dataSource.ArtistCacheDataSource
import com.example.tmdbclient.data.repository.tvShow.dataSource.TvShowCacheDataSource


class TvShowCacheDatSourceImpl: TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()


    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}