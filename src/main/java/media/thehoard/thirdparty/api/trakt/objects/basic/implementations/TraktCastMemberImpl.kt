package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCastMember
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl

data class TraktCastMemberImpl(override var character: String = "",
                               override var person: TraktPersonImpl = TraktPersonImpl()) : TraktCastMember
