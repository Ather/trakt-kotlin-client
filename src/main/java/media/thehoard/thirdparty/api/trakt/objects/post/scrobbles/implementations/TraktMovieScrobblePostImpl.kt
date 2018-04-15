package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.extensions.isValidProgress
import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.TraktMovieScrobblePost

data class TraktMovieScrobblePostImpl(
        override var progress: Float = 0f,
        @SerializedName("app_version")
        override var appVersion: String? = null,
        @SerializedName("app_date")
        override var appDate: String? = null,
        override var movie: TraktMovie = TraktMovieImpl()
) : TraktMovieScrobblePost {
    override fun validate(variableName: String) {
        progress.validate("progress value not valid - value must be between 0 and 100", ::isValidProgress, null)
        movie.validate()
    }
}