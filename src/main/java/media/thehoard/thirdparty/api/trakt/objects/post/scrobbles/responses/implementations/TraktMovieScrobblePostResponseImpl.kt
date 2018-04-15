package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses.implementations

import media.thehoard.thirdparty.api.trakt.enums.TraktScrobbleActionType
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktSharing
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses.TraktMovieScrobblePostResponse

class TraktMovieScrobblePostResponseImpl(
        override var id: Long = 0,
        override var action: TraktScrobbleActionType = TraktScrobbleActionType.UNSPECIFIED,
        override var progress: Float? = null,
        override var sharing: TraktSharing = TraktSharingImpl(),
        override var movie: TraktMovie = TraktMovieImpl()
) : TraktMovieScrobblePostResponse
