package com.atherapp.thirdparty.api.trakt.objects.get.seasons

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeCollectionProgress

interface TraktSeasonCollectionProgress : TraktSeasonProgress {
    var episodes: MutableList<TraktEpisodeCollectionProgress>
}
