package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import media.thehoard.thirdparty.api.trakt.enums.TraktObjectType
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserComment
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl

data class TraktUserCommentImpl(
        override var type: TraktObjectType = TraktObjectType.UNSPECIFIED,
        override var comment: TraktCommentImpl = TraktCommentImpl(),
        override var movie: TraktMovieImpl = TraktMovieImpl(),
        override var show: TraktShowImpl = TraktShowImpl(),
        override var season: TraktSeasonImpl = TraktSeasonImpl(),
        override var episode: TraktEpisodeImpl = TraktEpisodeImpl(),
        override var list: TraktListImpl = TraktListImpl()
) : TraktUserComment
