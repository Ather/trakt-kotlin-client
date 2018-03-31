package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponseGroup

data class TraktUserCustomListItemsPostResponseGroupImpl(
        override var movies: Int? = null,
        override var shows: Int? = null,
        override var seasons: Int? = null,
        override var episodes: Int? = null,
        override var people: Int? = null
) : TraktUserCustomListItemsPostResponseGroup
