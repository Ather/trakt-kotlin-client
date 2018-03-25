package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.TraktSyncRatingsPostResponseNotFoundShow

data class TraktSyncRatingsPostResponseNotFoundShowImpl(
        override var rating: Int? = null,
        override var ids: TraktShowIdsImpl = TraktShowIdsImpl()
) : TraktSyncRatingsPostResponseNotFoundShow
