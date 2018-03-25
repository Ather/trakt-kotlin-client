package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.TraktSyncRatingsPostResponseNotFoundSeason

data class TraktSyncRatingsPostResponseNotFoundSeasonImpl(
        override var rating: Int? = null,
        override var ids: TraktSeasonIdsImpl = TraktSeasonIdsImpl()
) : TraktSyncRatingsPostResponseNotFoundSeason
