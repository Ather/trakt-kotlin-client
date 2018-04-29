package com.atherapp.thirdparty.api.trakt.objects.post.comments

import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow

interface TraktShowCommentPost : TraktCommentPost {
    var show: TraktShow
}