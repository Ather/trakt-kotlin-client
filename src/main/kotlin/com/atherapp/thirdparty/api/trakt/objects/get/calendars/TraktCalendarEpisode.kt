package com.atherapp.thirdparty.api.trakt.objects.get.calendars

import com.atherapp.thirdparty.api.trakt.core.TraktEpisodeIds

interface TraktCalendarEpisode {
    var seasonNumber: Int

    var episodeNumber: Int

    var episodeTitle: String

    var episodeIds: TraktEpisodeIds
}
