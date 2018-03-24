package media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundSeason

data class TraktPostResponseNotFoundSeasonImpl(
        override var ids: TraktSeasonIdsImpl = TraktSeasonIdsImpl()
) : TraktPostResponseNotFoundSeason
