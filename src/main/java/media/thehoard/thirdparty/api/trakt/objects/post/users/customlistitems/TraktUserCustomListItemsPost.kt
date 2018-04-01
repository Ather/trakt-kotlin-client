package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems

import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations.TraktUserCustomListItemsPostMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations.TraktUserCustomListItemsPostShowImpl
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktUserCustomListItemsPost : IRequestBody {
    var movies: MutableList<TraktUserCustomListItemsPostMovieImpl>
    var shows: MutableList<TraktUserCustomListItemsPostShowImpl>
    var people: MutableList<TraktPersonImpl>
}