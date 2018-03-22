package media.thehoard.thirdparty.api.trakt.objects.post.comments

import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl

interface TraktListCommentPost : TraktCommentPost<TraktListCommentPost> {
    var list: TraktListImpl

    fun withList(list: TraktListImpl): TraktListCommentPost
}
