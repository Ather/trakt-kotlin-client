package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.enums.TraktHiddenItemType
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserHiddenItem
import java.time.ZonedDateTime

data class TraktUserHiddenItemImpl(
        @SerializedName("hidden_at") override var hiddenAt: ZonedDateTime? = null,
        override var type: TraktHiddenItemType = TraktHiddenItemType.UNSPECIFIIED,
        override var movie: TraktMovie? = TraktMovieImpl(),
        override var show: TraktShow? = TraktShowImpl(),
        override var season: TraktSeason? = TraktSeasonImpl()
) : TraktUserHiddenItem
