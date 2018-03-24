package media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.TraktCalendarShow
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import java.time.Instant

data class TraktCalendarShowImpl(
        @SerializedName("first_aired")
        override var firstAired: Instant? = null,
        override var episode: TraktEpisodeImpl = TraktEpisodeImpl(),
        override var show: TraktShowImpl = TraktShowImpl()
) : TraktCalendarShow {

    override var title: String
        get() = show.title
        set(title) {
            show.title = title
        }
    override var year: Int?
        get() = show.year
        set(year) {
            show.year = year
        }
    override var ids: TraktShowIdsImpl
        get() = show.ids
        set(ids) {
            show.ids = ids
        }

    override var seasonNumber: Int?
        get() = episode.season
        set(season) {
            episode.season = season
        }

    override var episodeNumber: Int?
        get() = episode.number
        set(number) {
            episode.number = number
        }

    override var episodeTitle: String
        get() = episode.title
        set(title) {
            episode.title = title
        }

    override var episodeIds: TraktEpisodeIdsImpl
        get() = episode.ids
        set(ids) {
            episode.ids = ids
        }
}
