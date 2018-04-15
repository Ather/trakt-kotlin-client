package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.enums.TraktGenreType
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktGenre

data class TraktGenreImpl(
        override var name: String = "",
        override var slug: String = "",
        override var type: TraktGenreType? = null
) : TraktGenre
