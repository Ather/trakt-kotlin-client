package com.atherapp.thirdparty.api.trakt.objects.get.users.implementations

import com.atherapp.thirdparty.api.trakt.enums.TraktObjectType
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktComment
import com.atherapp.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktUserComment
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl

data class TraktUserCommentImpl(
        override var type: TraktObjectType = TraktObjectType.UNSPECIFIED,
        override var comment: TraktComment = TraktCommentImpl(),
        override var movie: TraktMovie? = TraktMovieImpl(),
        override var show: TraktShow? = TraktShowImpl(),
        override var season: TraktSeason? = TraktSeasonImpl(),
        override var episode: TraktEpisode? = TraktEpisodeImpl(),
        override var list: TraktList? = TraktListImpl()
) : TraktUserComment
