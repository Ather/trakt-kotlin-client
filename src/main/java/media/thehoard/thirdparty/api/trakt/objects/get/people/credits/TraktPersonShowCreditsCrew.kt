package media.thehoard.thirdparty.api.trakt.objects.get.people.credits

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonShowCreditsCrewItemImpl

interface TraktPersonShowCreditsCrew {
    var production: List<TraktPersonShowCreditsCrewItemImpl>

    var art: List<TraktPersonShowCreditsCrewItemImpl>

    var crew: List<TraktPersonShowCreditsCrewItemImpl>

    var costumeAndMakeup: List<TraktPersonShowCreditsCrewItemImpl>

    var directing: List<TraktPersonShowCreditsCrewItemImpl>

    var writing: List<TraktPersonShowCreditsCrewItemImpl>

    var sound: List<TraktPersonShowCreditsCrewItemImpl>

    var camera: List<TraktPersonShowCreditsCrewItemImpl>

    var lighting: List<TraktPersonShowCreditsCrewItemImpl>

    var visualEffects: List<TraktPersonShowCreditsCrewItemImpl>

    var editing: List<TraktPersonShowCreditsCrewItemImpl>

}
