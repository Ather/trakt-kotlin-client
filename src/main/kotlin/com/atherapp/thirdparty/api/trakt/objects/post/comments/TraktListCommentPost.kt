package com.atherapp.thirdparty.api.trakt.objects.post.comments

import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList

interface TraktListCommentPost : TraktCommentPost {
    var list: TraktList
}
