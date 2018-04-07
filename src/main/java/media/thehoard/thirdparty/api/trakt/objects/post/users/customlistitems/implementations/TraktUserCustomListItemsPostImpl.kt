package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPost
import media.thehoard.thirdparty.api.trakt.utils.Json

data class TraktUserCustomListItemsPostImpl(
        override var movies: MutableList<TraktUserCustomListItemsPostMovieImpl> = mutableListOf(),
        override var shows: MutableList<TraktUserCustomListItemsPostShowImpl> = mutableListOf(),
        override var people: MutableList<TraktPersonImpl> = mutableListOf()
) : TraktUserCustomListItemsPost {
    override fun toJson(): String = Json.serialize(this)

    override fun validate() {}

    companion object {
        fun builder(): TraktUserCustomListItemsPostBuilder {
            return TraktUserCustomListItemsPostBuilder()
        }
    }
}

