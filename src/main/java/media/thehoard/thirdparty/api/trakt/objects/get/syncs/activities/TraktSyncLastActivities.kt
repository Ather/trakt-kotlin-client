package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities

import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations.*
import java.time.Instant

interface TraktSyncLastActivities {
    var all: Instant?

    var movies: TraktSyncMoviesLastActivitiesImpl

    var episodes: TraktSyncEpisodesLastActivitiesImpl

    var shows: TraktSyncShowsLastActivitiesImpl

    var seasons: TraktSyncSeasonsLastActivitiesImpl

    var comments: TraktSyncCommentsLastActivitiesImpl

    var lists: TraktSyncListsLastActivitiesImpl

}
