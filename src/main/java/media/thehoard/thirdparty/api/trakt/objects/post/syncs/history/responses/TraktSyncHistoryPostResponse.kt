package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseGroup
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseNotFoundGroup

interface TraktSyncHistoryPostResponse {
    var added: TraktSyncPostResponseGroup
    var notFound: TraktSyncPostResponseNotFoundGroup
}