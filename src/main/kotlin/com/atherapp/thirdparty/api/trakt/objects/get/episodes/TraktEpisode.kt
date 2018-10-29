package com.atherapp.thirdparty.api.trakt.objects.get.episodes

import com.atherapp.thirdparty.api.trakt.core.TraktEpisodeIds
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IValidatable
import java.time.ZonedDateTime

interface TraktEpisode : IValidatable {
    var season: Int

    var number: Int

    var title: String

    var ids: TraktEpisodeIds

    var numberAbsolute: Int?

    var overview: String?

    var firstAired: ZonedDateTime?

    var updatedAt: ZonedDateTime?

    var rating: Float?

    var votes: Int?

    var commentCount: Int?

    var availableTranslations: List<String>?

    var runtime: Int?
}
