package media.thehoard.thirdparty.api.trakt.objects.get.people.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPerson

data class TraktPersonImpl(
        override var name: String = "",
        override var ids: TraktPersonIdsImpl = TraktPersonIdsImpl()
) : TraktPerson
