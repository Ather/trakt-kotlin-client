package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.*
import java.time.ZonedDateTime

data class TraktSyncLastActivitiesImpl(
        override var all: ZonedDateTime? = null,
        override var movies: TraktSyncMoviesLastActivities = TraktSyncMoviesLastActivitiesImpl(),
        override var episodes: TraktSyncEpisodesLastActivities = TraktSyncEpisodesLastActivitiesImpl(),
        override var shows: TraktSyncShowsLastActivities = TraktSyncShowsLastActivitiesImpl(),
        override var seasons: TraktSyncSeasonsLastActivities = TraktSyncSeasonsLastActivitiesImpl(),
        override var comments: TraktSyncCommentsLastActivities = TraktSyncCommentsLastActivitiesImpl(),
        override var lists: TraktSyncListsLastActivities = TraktSyncListsLastActivitiesImpl()
) : TraktSyncLastActivities
