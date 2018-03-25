package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostShow

data class TraktUserCustomListItemsPostShowImpl(
        override var ids: TraktShowIdsImpl = TraktShowIdsImpl(),
        override var seasons: MutableList<TraktUserCustomListItemsPostShowSeasonImpl> = mutableListOf()
) : TraktUserCustomListItemsPostShow
