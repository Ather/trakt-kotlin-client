package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCreditsCrew

data class TraktPersonMovieCreditsCrewImpl(
        override var production: List<TraktPersonMovieCreditsCrewItemImpl> = listOf(),
        override var art: List<TraktPersonMovieCreditsCrewItemImpl> = listOf(),
        override var crew: List<TraktPersonMovieCreditsCrewItemImpl> = listOf(),
        @SerializedName("costume & make-up")
        override var costumeAndMakeup: List<TraktPersonMovieCreditsCrewItemImpl> = listOf(),
        override var directing: List<TraktPersonMovieCreditsCrewItemImpl> = listOf(),
        override var writing: List<TraktPersonMovieCreditsCrewItemImpl> = listOf(),
        override var sound: List<TraktPersonMovieCreditsCrewItemImpl> = listOf(),
        override var camera: List<TraktPersonMovieCreditsCrewItemImpl> = listOf(),
        override var lighting: List<TraktPersonMovieCreditsCrewItemImpl> = listOf(),
        @SerializedName("visual effects")
        override var visualEffects: List<TraktPersonMovieCreditsCrewItemImpl> = listOf(),
        override var editing: List<TraktPersonMovieCreditsCrewItemImpl> = listOf()
) : TraktPersonMovieCreditsCrew