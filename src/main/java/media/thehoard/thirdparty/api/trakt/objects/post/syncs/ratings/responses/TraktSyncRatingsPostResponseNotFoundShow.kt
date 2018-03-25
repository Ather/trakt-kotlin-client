package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl

interface TraktSyncRatingsPostResponseNotFoundShow {
    var rating: Int?
    var ids: TraktShowIdsImpl
}