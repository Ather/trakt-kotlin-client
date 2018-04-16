package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktSyncCollectionPost : IRequestBody {
    var movies: MutableList<TraktSyncCollectionPostMovie>

    var shows: MutableList<TraktSyncCollectionPostShow>

    var episodes: MutableList<TraktSyncCollectionPostEpisode>
}