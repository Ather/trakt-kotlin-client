package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl

interface TraktSyncRatingsRemovePostResponse {
    var deleted: TraktSyncPostResponseGroupImpl
    var notFound: TraktSyncPostResponseNotFoundGroupImpl
}