package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCastAndCrew

data class TraktCastAndCrewImpl(override var cast: List<TraktCastMemberImpl> = listOf(),
                                override var crew: TraktCrewImpl = TraktCrewImpl()) : TraktCastAndCrew
