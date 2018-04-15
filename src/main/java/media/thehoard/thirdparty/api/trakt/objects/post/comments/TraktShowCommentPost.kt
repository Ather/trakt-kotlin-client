package media.thehoard.thirdparty.api.trakt.objects.post.comments

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow

interface TraktShowCommentPost : TraktCommentPost {
    var show: TraktShow
}