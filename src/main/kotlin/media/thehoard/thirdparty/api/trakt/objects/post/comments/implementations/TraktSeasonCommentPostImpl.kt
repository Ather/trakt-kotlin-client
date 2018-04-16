package media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktSharing
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktSeasonCommentPost

data class TraktSeasonCommentPostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null,
        override var sharing: TraktSharing? = null,
        override var season: TraktSeason = TraktSeasonImpl()
) : TraktSeasonCommentPost {
    override fun validate(variableName: String) {
        super.validate(variableName)
        season.validate()
    }
}
