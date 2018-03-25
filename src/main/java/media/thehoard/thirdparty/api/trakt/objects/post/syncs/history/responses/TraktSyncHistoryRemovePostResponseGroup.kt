package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseGroup

interface TraktSyncHistoryRemovePostResponseGroup : TraktSyncPostResponseGroup {
    var ids: Int?
}