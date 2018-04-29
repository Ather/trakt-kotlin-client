package com.atherapp.thirdparty.api.trakt.objects.post.comments

import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason

interface TraktSeasonCommentPost : TraktCommentPost {
    var season: TraktSeason
}