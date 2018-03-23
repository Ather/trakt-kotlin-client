package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowAlias

data class TraktShowAliasImpl(override var title: String = "",
                              override var country: String = "") : TraktShowAlias
