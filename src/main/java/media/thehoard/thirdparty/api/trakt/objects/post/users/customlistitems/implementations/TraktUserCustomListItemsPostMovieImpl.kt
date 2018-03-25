package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostMovie

data class TraktUserCustomListItemsPostMovieImpl(
        override var ids: TraktMovieIdsImpl = TraktMovieIdsImpl()
) : TraktUserCustomListItemsPostMovie
