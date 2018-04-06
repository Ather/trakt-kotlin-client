package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities

import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations.*
import java.time.ZonedDateTime

interface TraktSyncLastActivities {
    var all: ZonedDateTime?

    var movies: TraktSyncMoviesLastActivitiesImpl

    var episodes: TraktSyncEpisodesLastActivitiesImpl

    var shows: TraktSyncShowsLastActivitiesImpl

    var seasons: TraktSyncSeasonsLastActivitiesImpl

    var comments: TraktSyncCommentsLastActivitiesImpl

    var lists: TraktSyncListsLastActivitiesImpl

}
