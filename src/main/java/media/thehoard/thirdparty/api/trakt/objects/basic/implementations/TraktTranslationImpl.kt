package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktTranslation

data class TraktTranslationImpl(override var title: String = "",
                                override var overview: String = "",
                                override var language: String = "") : TraktTranslation {
    //TODO Language Enum
    override fun toString(): String = if (!title.isEmpty()) title else "no title set"
}
