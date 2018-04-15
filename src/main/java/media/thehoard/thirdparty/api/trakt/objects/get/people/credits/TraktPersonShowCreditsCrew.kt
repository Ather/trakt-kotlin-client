package media.thehoard.thirdparty.api.trakt.objects.get.people.credits

interface TraktPersonShowCreditsCrew {
    var production: List<TraktPersonShowCreditsCrewItem>

    var art: List<TraktPersonShowCreditsCrewItem>

    var crew: List<TraktPersonShowCreditsCrewItem>

    var costumeAndMakeup: List<TraktPersonShowCreditsCrewItem>

    var directing: List<TraktPersonShowCreditsCrewItem>

    var writing: List<TraktPersonShowCreditsCrewItem>

    var sound: List<TraktPersonShowCreditsCrewItem>

    var camera: List<TraktPersonShowCreditsCrewItem>

    var lighting: List<TraktPersonShowCreditsCrewItem>

    var visualEffects: List<TraktPersonShowCreditsCrewItem>

    var editing: List<TraktPersonShowCreditsCrewItem>

}
