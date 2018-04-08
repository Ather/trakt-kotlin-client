package media.thehoard.thirdparty.api.trakt.objects.get.people.credits

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonMovieCreditsCrewItemImpl

interface TraktPersonMovieCreditsCrew {
    var production: List<TraktPersonMovieCreditsCrewItemImpl>

    var art: List<TraktPersonMovieCreditsCrewItemImpl>

    var crew: List<TraktPersonMovieCreditsCrewItemImpl>

    var costumeAndMakeup: List<TraktPersonMovieCreditsCrewItemImpl>

    var directing: List<TraktPersonMovieCreditsCrewItemImpl>

    var writing: List<TraktPersonMovieCreditsCrewItemImpl>

    var sound: List<TraktPersonMovieCreditsCrewItemImpl>

    var camera: List<TraktPersonMovieCreditsCrewItemImpl>

    var lighting: List<TraktPersonMovieCreditsCrewItemImpl>

    var visualEffects: List<TraktPersonMovieCreditsCrewItemImpl>

    var editing: List<TraktPersonMovieCreditsCrewItemImpl>

}
