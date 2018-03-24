package media.thehoard.thirdparty.api.trakt.objects.get.episodes

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl

interface TraktEpisode {
    var season: Int?

    var number: Int?

    var title: String

    var ids: TraktEpisodeIdsImpl
}
