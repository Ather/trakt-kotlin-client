package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.TraktCheckinPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.TraktMovieCheckinPostResponse

import java.time.Instant

data class TraktMovieCheckinPostResponseImpl(
        override var id: Long = 0,
        @SerializedName("watched_at") override var watchedAt: Instant? = null,
        override var sharing: TraktSharingImpl = TraktSharingImpl(),
        override var movie: TraktMovieImpl = TraktMovieImpl()
) : TraktMovieCheckinPostResponse
