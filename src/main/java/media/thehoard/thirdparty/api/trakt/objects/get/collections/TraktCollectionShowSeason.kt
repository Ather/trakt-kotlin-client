package media.thehoard.thirdparty.api.trakt.objects.get.collections

import media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionShowEpisodeImpl

interface TraktCollectionShowSeason {
    var number: Int?

    var episodes: MutableList<TraktCollectionShowEpisodeImpl>

}
