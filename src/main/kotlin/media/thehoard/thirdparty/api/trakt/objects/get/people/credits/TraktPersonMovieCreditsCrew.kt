package media.thehoard.thirdparty.api.trakt.objects.get.people.credits

interface TraktPersonMovieCreditsCrew {
    var production: List<TraktPersonMovieCreditsCrewItem>

    var art: List<TraktPersonMovieCreditsCrewItem>

    var crew: List<TraktPersonMovieCreditsCrewItem>

    var costumeAndMakeup: List<TraktPersonMovieCreditsCrewItem>

    var directing: List<TraktPersonMovieCreditsCrewItem>

    var writing: List<TraktPersonMovieCreditsCrewItem>

    var sound: List<TraktPersonMovieCreditsCrewItem>

    var camera: List<TraktPersonMovieCreditsCrewItem>

    var lighting: List<TraktPersonMovieCreditsCrewItem>

    var visualEffects: List<TraktPersonMovieCreditsCrewItem>

    var editing: List<TraktPersonMovieCreditsCrewItem>

}
