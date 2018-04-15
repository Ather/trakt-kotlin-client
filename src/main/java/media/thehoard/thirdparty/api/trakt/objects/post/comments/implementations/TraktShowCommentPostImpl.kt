package media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktSharing
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktShowCommentPost

data class TraktShowCommentPostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null,
        override var sharing: TraktSharing? = null,
        override var show: TraktShow = TraktShowImpl()
) : TraktShowCommentPost {
    override fun validate(variableName: String) {
        super.validate(variableName)
        show.validate()
    }
}
