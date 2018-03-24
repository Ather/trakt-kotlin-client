package media.thehoard.thirdparty.api.trakt.objects.post.responses

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl

interface TraktPostResponseNotFoundEpisode {
    var ids: TraktEpisodeIdsImpl
}