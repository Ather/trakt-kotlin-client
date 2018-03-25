package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryRemovePostResponseGroup
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseGroup

data class TraktSyncHistoryRemovePostResponseGroupImpl(
        override var movies: Int? = null,
        override var shows: Int? = null,
        override var seasons: Int? = null,
        override var episodes: Int? = null,
        override var ids: Int? = null
) : TraktSyncHistoryRemovePostResponseGroup