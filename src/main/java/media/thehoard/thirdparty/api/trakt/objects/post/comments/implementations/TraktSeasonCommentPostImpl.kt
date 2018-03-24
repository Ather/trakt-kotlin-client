package media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktSeasonCommentPost

data class TraktSeasonCommentPostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null,
        override var sharing: TraktSharingImpl = TraktSharingImpl(),
        override var season: TraktSeasonImpl = TraktSeasonImpl()
) : TraktSeasonCommentPost
