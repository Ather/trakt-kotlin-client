package media.thehoard.thirdparty.api.trakt.objects.post.comments

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

interface TraktShowCommentPost : TraktCommentPost {
    var show: TraktShowImpl
}