package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCastAndCrew
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCastMember
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCrew

data class TraktCastAndCrewImpl(
        override var cast: List<TraktCastMember> = listOf(),
        override var crew: TraktCrew = TraktCrewImpl()
) : TraktCastAndCrew
