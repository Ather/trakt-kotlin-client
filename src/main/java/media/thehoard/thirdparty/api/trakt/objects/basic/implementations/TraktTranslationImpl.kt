package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktTranslation

open class TraktTranslationImpl(
        override var title: String = "",
        override var overview: String? = null,
        override var language: String? = null
) : TraktTranslation {
    //TODO Language Enum
    override fun toString(): String = if (!title.isEmpty()) title else "no title set"
}
