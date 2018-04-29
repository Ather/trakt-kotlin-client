package com.atherapp.thirdparty.api.trakt.objects.get.shows

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason

interface TraktShowProgress {
    var aired: Int?

    var completed: Int?

    var hiddenSeasons: MutableList<TraktSeason>

    var nextEpisode: TraktEpisode

    var lastEpisode: TraktEpisode
}
