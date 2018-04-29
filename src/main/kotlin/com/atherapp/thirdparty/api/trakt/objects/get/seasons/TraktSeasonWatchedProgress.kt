package com.atherapp.thirdparty.api.trakt.objects.get.seasons

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeWatchedProgress

interface TraktSeasonWatchedProgress : TraktSeasonProgress {
    var episodes: MutableList<TraktEpisodeWatchedProgress>

}
