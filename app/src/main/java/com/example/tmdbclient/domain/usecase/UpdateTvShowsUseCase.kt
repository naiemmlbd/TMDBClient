package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.domain.repository.TvShowRepo


class UpdateTvShowsUseCase(private val tvShowRepo: TvShowRepo) {

    suspend fun execute():List<TvShow>? = tvShowRepo.updateTvShows()

}