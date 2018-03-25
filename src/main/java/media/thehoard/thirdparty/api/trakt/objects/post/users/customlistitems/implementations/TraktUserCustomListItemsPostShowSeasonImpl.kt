package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostShowSeason

data class TraktUserCustomListItemsPostShowSeasonImpl(
        override var number: Int = 0,
        override var episodes: MutableList<TraktUserCustomListItemsPostShowEpisodeImpl> = mutableListOf()
) : TraktUserCustomListItemsPostShowSeason
