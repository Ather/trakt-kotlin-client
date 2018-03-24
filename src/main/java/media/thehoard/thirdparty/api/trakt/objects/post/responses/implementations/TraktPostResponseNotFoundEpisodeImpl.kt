package media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundEpisode

data class TraktPostResponseNotFoundEpisodeImpl(
        override var ids: TraktEpisodeIdsImpl = TraktEpisodeIdsImpl()
) : TraktPostResponseNotFoundEpisode
