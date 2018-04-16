package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.post.PostSeasons
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.AbstractTraktSyncPostBuilder
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPost
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostShowEpisode
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostShowSeason
import java.util.*

class TraktUserCustomListItemsPostBuilder : AbstractTraktSyncPostBuilder<TraktUserCustomListItemsPost, TraktUserCustomListItemsPostBuilder>() {
    private val listItemsPost: TraktUserCustomListItemsPostImpl = TraktUserCustomListItemsPostImpl()

    fun addMovie(movie: TraktMovie): TraktUserCustomListItemsPostBuilder {
        if (!movie.ids.hasAnyId())
            throw IllegalArgumentException("no movie ids set or valid")

        if (movie.year.toString().length != 4)
            throw IllegalArgumentException("movie year not valid")

        val existingMovie = listItemsPost.movies.firstOrNull { mov -> mov.ids like movie.ids }

        if (existingMovie != null)
            return this

        listItemsPost.movies.add(TraktUserCustomListItemsPostMovieImpl(movie.ids))

        return this
    }

    fun addMovies(movies: Collection<TraktMovieImpl>): TraktUserCustomListItemsPostBuilder {
        for (movie in movies)
            addMovie(movie)

        return this
    }

    fun addShow(show: TraktShowImpl): TraktUserCustomListItemsPostBuilder {
        show.validate()

        val existingShow = listItemsPost.shows.firstOrNull { mov -> mov.ids like show.ids }

        if (existingShow != null)
            return this

        listItemsPost.shows.add(TraktUserCustomListItemsPostShowImpl(show.ids))

        return this
    }

    fun addShows(shows: Collection<TraktShowImpl>): TraktUserCustomListItemsPostBuilder {
        for (show in shows)
            addShow(show)

        return this
    }

    fun addShow(show: TraktShow, vararg seasons: Int): TraktUserCustomListItemsPostBuilder {
        show.validate()

        val showSeasons = ArrayList<TraktUserCustomListItemsPostShowSeason>()

        for (season in seasons) {
            if (season < 0)
                throw IllegalArgumentException("at least one season number not valid")

            showSeasons.add(TraktUserCustomListItemsPostShowSeasonImpl(season))
        }

        val existingShow = listItemsPost.shows.firstOrNull { mov -> mov.ids like show.ids }

        if (existingShow != null)
            existingShow.seasons = showSeasons
        else
            listItemsPost.shows.add(TraktUserCustomListItemsPostShowImpl(show.ids, showSeasons))

        return this
    }

    fun addShow(show: TraktShowImpl, seasons: PostSeasons): TraktUserCustomListItemsPostBuilder {
        show.validate()

        val showSeasons: MutableList<TraktUserCustomListItemsPostShowSeason> = mutableListOf()

        if (seasons.size > 0) {
            for (season in seasons) {
                if (season.number < 0)
                    throw IllegalArgumentException("at least one season number not valid")

                val showSingleSeason = TraktUserCustomListItemsPostShowSeasonImpl(season.number)

                if (season.episodes.isNotEmpty()) {
                    val showEpisodes = ArrayList<TraktUserCustomListItemsPostShowEpisode>()

                    for (episode in season.episodes) {
                        if (episode < 0)
                            throw IllegalArgumentException("at least one episode number not valid")

                        showEpisodes.add(TraktUserCustomListItemsPostShowEpisodeImpl(episode))
                    }

                    showSingleSeason.episodes = showEpisodes
                }

                showSeasons.add(showSingleSeason)
            }
        }

        val existingShow = listItemsPost.shows.firstOrNull { sh -> sh.ids like show.ids }

        if (existingShow != null)
            existingShow.seasons = showSeasons
        else
            listItemsPost.shows.add(TraktUserCustomListItemsPostShowImpl(show.ids, showSeasons))

        return this
    }

    fun addPerson(person: TraktPersonImpl): TraktUserCustomListItemsPostBuilder {
        if (!person.ids.hasAnyId())
            throw IllegalArgumentException("no person ids set or valid")

        if (person.name.isEmpty())
            throw IllegalArgumentException("person name not valid")

        val existingPerson = listItemsPost.people.firstOrNull { pers -> pers.ids like person.ids }

        if (existingPerson != null)
            return this

        listItemsPost.people.add(person)

        return this
    }

    fun addPersons(persons: Collection<TraktPersonImpl>): TraktUserCustomListItemsPostBuilder {
        for (person in persons)
            addPerson(person)

        return this
    }

    override fun reset() {
        listItemsPost.movies.clear()

        listItemsPost.shows.clear()

        listItemsPost.people.clear()
    }

    override fun build(): TraktUserCustomListItemsPostImpl {
        return listItemsPost
    }

    override fun self(): TraktUserCustomListItemsPostBuilder {
        return this
    }
}