package media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeWatchedProgressImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonWatchedProgress

data class TraktSeasonWatchedProgressImpl(override var number: Int? = null,
                                          override var aired: Int? = null,
                                          override var completed: Int? = null,
                                          override var episodes: List<TraktEpisodeWatchedProgressImpl> = listOf()) : TraktSeasonWatchedProgress
