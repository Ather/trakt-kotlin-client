package media.thehoard.thirdparty.api.trakt.objects.get.calendars

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl

interface TraktCalendarEpisode {
    var seasonNumber: Int

    var episodeNumber: Int

    var episodeTitle: String

    var episodeIds: TraktEpisodeIdsImpl
}
