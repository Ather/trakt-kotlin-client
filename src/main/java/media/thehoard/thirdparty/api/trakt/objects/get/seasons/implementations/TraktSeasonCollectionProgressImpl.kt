package media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeCollectionProgressImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonCollectionProgress

class TraktSeasonCollectionProgressImpl(override var number: Int? = null,
                                        override var aired: Int? = null,
                                        override var completed: Int? = null,
                                        override var episodes: List<TraktEpisodeCollectionProgressImpl> = listOf()) : TraktSeasonCollectionProgress
