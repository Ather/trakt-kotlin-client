package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCrewMember
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl

data class TraktCrewMemberImpl(
        override var job: String = "",
        override var person: TraktPersonImpl = TraktPersonImpl()
) : TraktCrewMember
