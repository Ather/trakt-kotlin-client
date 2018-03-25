package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseNotFoundGroup

interface TraktSyncHistoryRemovePostResponseNotFoundGroup : TraktSyncPostResponseNotFoundGroup {
    var ids: List<Long>
}