package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseGroup
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseNotFoundGroup

interface TraktSyncHistoryRemovePostResponse {
    var deleted: TraktSyncPostResponseGroup
    var notFound: TraktSyncPostResponseNotFoundGroup
}