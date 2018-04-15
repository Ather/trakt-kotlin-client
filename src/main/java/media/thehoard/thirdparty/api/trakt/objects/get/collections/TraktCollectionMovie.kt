package media.thehoard.thirdparty.api.trakt.objects.get.collections

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktMetadata
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import java.time.ZonedDateTime

interface TraktCollectionMovie : TraktMovie {
    var collectedAt: ZonedDateTime?

    var movie: TraktMovie

    var metadata: TraktMetadata?
}