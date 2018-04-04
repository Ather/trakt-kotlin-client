package media.thehoard.thirdparty.api.trakt.services

import java.util.*
import kotlin.collections.ArrayList

object TraktLanguageService {
    fun getLanguage(languageCode: String): String {
        if (languageCode.isBlank())
            return ""

        return Locale(languageCode).displayLanguage
    }

    fun getAvailableTranslationLanguages(availableTranslationLanguages: List<String>): MutableList<String> {
        val languages = ArrayList<String>(availableTranslationLanguages.size)

        for (languageCode in availableTranslationLanguages)
            languages.add(Locale(languageCode).displayLanguage)

        return languages
    }

    fun getCountry(countryCode: String): String {
        if (countryCode.isBlank())
            return ""

        return Locale("", countryCode).displayCountry
    }
}
