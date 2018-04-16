package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.responses

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl

interface TraktSyncCollectionPostResponse {
    var added: TraktSyncPostResponseGroupImpl
    var updated: TraktSyncPostResponseGroupImpl
    var existing: TraktSyncPostResponseGroupImpl
    var notFound: TraktSyncPostResponseNotFoundGroupImpl
}