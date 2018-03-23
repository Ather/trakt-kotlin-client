package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowTranslation

data class TraktShowTranslationImpl(override var title: String = "",
                                    override var overview: String = "",
                                    override var language: String = "") : TraktShowTranslation
