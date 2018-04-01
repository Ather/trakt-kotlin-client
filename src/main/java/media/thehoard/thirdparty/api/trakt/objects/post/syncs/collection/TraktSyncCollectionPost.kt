package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations.TraktSyncCollectionPostEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations.TraktSyncCollectionPostMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations.TraktSyncCollectionPostShowImpl
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktSyncCollectionPost : IRequestBody {
    var movies: MutableList<TraktSyncCollectionPostMovieImpl>

    var shows: MutableList<TraktSyncCollectionPostShowImpl>

    var episodes: MutableList<TraktSyncCollectionPostEpisodeImpl>
}