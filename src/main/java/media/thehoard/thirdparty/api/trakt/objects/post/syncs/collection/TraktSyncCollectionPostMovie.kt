package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import java.time.ZonedDateTime

interface TraktSyncCollectionPostMovie {
    var collectedAt: ZonedDateTime?

    var title: String

    var year: Int?

    var ids: TraktMovieIdsImpl

    var metadata: TraktMetadataImpl?
}