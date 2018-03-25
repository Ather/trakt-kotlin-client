package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations.*

interface TraktSyncCollectionPostShowSeason {
    var number: Int

    var episodes: MutableList<TraktSyncCollectionPostShowEpisodeImpl>
}