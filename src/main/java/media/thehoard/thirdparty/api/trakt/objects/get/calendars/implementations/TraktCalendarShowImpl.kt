package media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.TraktCalendarShow
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import java.time.ZonedDateTime

data class TraktCalendarShowImpl(
        @SerializedName("first_aired")
        override var firstAiredInCalendar: ZonedDateTime? = null,
        override var episode: TraktEpisode = TraktEpisodeImpl(),
        override var show: TraktShow = TraktShowImpl()
) : TraktCalendarShow, TraktShow by show {
    override var seasonNumber: Int
        get() = episode.season
        set(season) {
            episode.season = season
        }

    override var episodeNumber: Int
        get() = episode.number
        set(number) {
            episode.number = number
        }

    override var episodeTitle: String
        get() = episode.title
        set(title) {
            episode.title = title
        }

    override var episodeIds: TraktEpisodeIds
        get() = episode.ids
        set(ids) {
            episode.ids = ids
        }
}
