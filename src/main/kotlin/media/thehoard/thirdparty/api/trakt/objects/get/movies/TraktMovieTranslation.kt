package media.thehoard.thirdparty.api.trakt.objects.get.movies

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktTranslation

interface TraktMovieTranslation : TraktTranslation {
    var tagline: String?

}
