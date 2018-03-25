package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations.TraktSyncCollectionPostEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations.TraktSyncCollectionPostMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations.TraktSyncCollectionPostShowImpl

interface TraktSyncCollectionPost {
    var movies: MutableList<TraktSyncCollectionPostMovieImpl>

    var shows: MutableList<TraktSyncCollectionPostShowImpl>

    var episodes: MutableList<TraktSyncCollectionPostEpisodeImpl>
}