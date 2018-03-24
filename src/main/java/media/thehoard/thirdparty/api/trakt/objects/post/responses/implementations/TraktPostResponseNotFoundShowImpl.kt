package media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundShow

data class TraktPostResponseNotFoundShowImpl(
        override var ids: TraktShowIdsImpl = TraktShowIdsImpl()
) : TraktPostResponseNotFoundShow
