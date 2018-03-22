package media.thehoard.thirdparty.api.trakt.objects.basic

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCastMemberImpl
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCrewImpl

interface TraktCastAndCrew {
    var cast: List<TraktCastMemberImpl>

    var crew: TraktCrewImpl
}
