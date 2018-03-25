package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl

interface TraktUserCustomListItemsPostMovie {
    var ids: TraktMovieIdsImpl
}