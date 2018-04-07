package media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowSeason

data class TraktCollectionShowSeasonImpl(
        override var number: Int? = null,
        override var episodes: MutableList<TraktCollectionShowEpisodeImpl> = mutableListOf()
) : TraktCollectionShowSeason
