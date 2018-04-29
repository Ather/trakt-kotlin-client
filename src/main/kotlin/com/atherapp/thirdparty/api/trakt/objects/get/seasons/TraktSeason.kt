package com.atherapp.thirdparty.api.trakt.objects.get.seasons

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IValidatable
import java.time.ZonedDateTime

interface TraktSeason : IValidatable {
    var number: Int

    var ids: TraktSeasonIds

    var rating: Float?

    var votes: Int?

    var episodeCount: Int?

    var airedEpisodes: Int?

    var title: String?

    var overview: String?

    var firstAired: ZonedDateTime?

    var network: String?

    var episodes: MutableList<TraktEpisode>?
}
