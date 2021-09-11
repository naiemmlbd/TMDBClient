

import com.anushka.tmdbclient.presentation.di.movie.MovieModule
import com.anushka.tmdbclient.presentation.di.movie.MovieScope
import com.example.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }

}

