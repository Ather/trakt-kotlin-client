package media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeProgress

data class TraktEpisodeProgressImpl(
        override var number: Int? = null,
        override var completed: Boolean? = null
) : TraktEpisodeProgress
