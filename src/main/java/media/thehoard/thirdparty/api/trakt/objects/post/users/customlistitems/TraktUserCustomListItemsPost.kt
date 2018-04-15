package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems

import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPerson
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktUserCustomListItemsPost : IRequestBody {
    var movies: MutableList<TraktUserCustomListItemsPostMovie>
    var shows: MutableList<TraktUserCustomListItemsPostShow>
    var people: MutableList<TraktPerson>
}