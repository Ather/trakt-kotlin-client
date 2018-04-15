package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCreditsCrew
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCreditsCrewItem

data class TraktPersonMovieCreditsCrewImpl(
        override var production: List<TraktPersonMovieCreditsCrewItem> = listOf(),
        override var art: List<TraktPersonMovieCreditsCrewItem> = listOf(),
        override var crew: List<TraktPersonMovieCreditsCrewItem> = listOf(),
        @SerializedName("costume & make-up")
        override var costumeAndMakeup: List<TraktPersonMovieCreditsCrewItem> = listOf(),
        override var directing: List<TraktPersonMovieCreditsCrewItem> = listOf(),
        override var writing: List<TraktPersonMovieCreditsCrewItem> = listOf(),
        override var sound: List<TraktPersonMovieCreditsCrewItem> = listOf(),
        override var camera: List<TraktPersonMovieCreditsCrewItem> = listOf(),
        override var lighting: List<TraktPersonMovieCreditsCrewItem> = listOf(),
        @SerializedName("visual effects")
        override var visualEffects: List<TraktPersonMovieCreditsCrewItem> = listOf(),
        override var editing: List<TraktPersonMovieCreditsCrewItem> = listOf()
) : TraktPersonMovieCreditsCrew