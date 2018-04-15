package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowIds

interface TraktUserCustomListItemsPostShow {
    var ids: TraktShowIds
    var seasons: MutableList<TraktUserCustomListItemsPostShowSeason>
}