package com.atherapp.thirdparty.api.trakt.objects.get.users

import com.atherapp.thirdparty.api.trakt.enums.TraktObjectType
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktComment
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList

interface TraktUserComment {
    var type: TraktObjectType

    var comment: TraktComment

    var movie: TraktMovie?

    var show: TraktShow?

    var season: TraktSeason?

    var episode: TraktEpisode?

    var list: TraktList?

}
