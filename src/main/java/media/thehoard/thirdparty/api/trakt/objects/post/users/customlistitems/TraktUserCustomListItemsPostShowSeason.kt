package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems

import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations.TraktUserCustomListItemsPostShowEpisodeImpl

interface TraktUserCustomListItemsPostShowSeason {
    var number: Int
    var episodes: MutableList<TraktUserCustomListItemsPostShowEpisodeImpl>
}