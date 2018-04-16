package media.thehoard.thirdparty.api.trakt.objects.basic

interface TraktCastAndCrew {
    var cast: List<TraktCastMember>

    var crew: TraktCrew
}
