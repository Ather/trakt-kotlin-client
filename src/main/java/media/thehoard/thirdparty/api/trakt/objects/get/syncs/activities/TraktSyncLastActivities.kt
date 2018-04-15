package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities

import java.time.ZonedDateTime

interface TraktSyncLastActivities {
    var all: ZonedDateTime?

    var movies: TraktSyncMoviesLastActivities

    var episodes: TraktSyncEpisodesLastActivities

    var shows: TraktSyncShowsLastActivities

    var seasons: TraktSyncSeasonsLastActivities

    var comments: TraktSyncCommentsLastActivities

    var lists: TraktSyncListsLastActivities

}
