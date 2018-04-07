package media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeTranslation

data class TraktEpisodeTranslationImpl(
        override var title: String = "",
        override var overview: String? = null,
        override var language: String? = null
) : TraktEpisodeTranslation
