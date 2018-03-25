package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations.TraktUserCustomListItemsPostShowSeasonImpl

interface TraktUserCustomListItemsPostShow {
    var ids: TraktShowIdsImpl
    var seasons: MutableList<TraktUserCustomListItemsPostShowSeasonImpl>
}