package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieTranslation

class TraktMovieTranslationImpl(override var title: String = "",
                                override var overview: String = "",
                                override var language: String = "",
                                override var tagline: String = "") : TraktMovieTranslation
