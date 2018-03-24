package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.enums.TraktHiddenItemType
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserHiddenItem

import java.time.Instant

data class TraktUserHiddenItemImpl(
        @SerializedName("hidden_at") override var hiddenAt: Instant? = null,
        override var type: TraktHiddenItemType = TraktHiddenItemType.UNSPECIFIIED,
        override var movie: TraktMovieImpl = TraktMovieImpl(),
        override var show: TraktShowImpl = TraktShowImpl(),
        override var season: TraktSeasonImpl = TraktSeasonImpl()
) : TraktUserHiddenItem
