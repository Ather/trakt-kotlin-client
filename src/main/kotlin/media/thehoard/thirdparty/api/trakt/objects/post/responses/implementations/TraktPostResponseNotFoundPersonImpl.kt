package media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPersonIds
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundPerson

data class TraktPostResponseNotFoundPersonImpl(
        override var ids: TraktPersonIds = TraktPersonIdsImpl()
) : TraktPostResponseNotFoundPerson
