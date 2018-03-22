package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktGenre

data class TraktGenreImpl(override var name: String = "",
                          override var slug: String = "") : TraktGenre
