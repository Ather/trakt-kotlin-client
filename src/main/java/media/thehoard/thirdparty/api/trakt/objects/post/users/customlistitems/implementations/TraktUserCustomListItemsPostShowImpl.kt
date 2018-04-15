package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowIds
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostShow
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostShowSeason

data class TraktUserCustomListItemsPostShowImpl(
        override var ids: TraktShowIds = TraktShowIdsImpl(),
        override var seasons: MutableList<TraktUserCustomListItemsPostShowSeason> = mutableListOf()
) : TraktUserCustomListItemsPostShow
