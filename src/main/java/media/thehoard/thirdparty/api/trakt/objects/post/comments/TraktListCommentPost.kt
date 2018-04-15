package media.thehoard.thirdparty.api.trakt.objects.post.comments

import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList

interface TraktListCommentPost : TraktCommentPost {
    var list: TraktList
}
