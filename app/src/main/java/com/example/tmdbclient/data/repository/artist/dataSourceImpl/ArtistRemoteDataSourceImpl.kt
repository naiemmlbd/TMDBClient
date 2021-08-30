package com.example.tmdbclient.data.repository.artist.dataSourceImpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.model.tvshow.TvShowList
import com.example.tmdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import retrofit2.Response


class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String):ArtistRemoteDataSource {


    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}