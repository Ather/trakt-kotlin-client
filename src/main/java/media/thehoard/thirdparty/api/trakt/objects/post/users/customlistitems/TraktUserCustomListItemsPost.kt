package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems

import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations.TraktUserCustomListItemsPostMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations.TraktUserCustomListItemsPostShowImpl

interface TraktUserCustomListItemsPost {
    var movies: MutableList<TraktUserCustomListItemsPostMovieImpl>
    var shows: MutableList<TraktUserCustomListItemsPostShowImpl>
    var people: MutableList<TraktPersonImpl>
}