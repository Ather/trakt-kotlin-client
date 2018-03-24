package media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode

data class TraktEpisodeImpl(override var season: Int? = null,
                            override var number: Int? = null,
                            override var title: String = "",
                            override var ids: TraktEpisodeIdsImpl = TraktEpisodeIdsImpl()) : TraktEpisode
