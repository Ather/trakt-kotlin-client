package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncLastActivities
import java.time.Instant

data class TraktSyncLastActivitiesImpl(
        override var all: Instant? = null,
        override var movies: TraktSyncMoviesLastActivitiesImpl = TraktSyncMoviesLastActivitiesImpl(),
        override var episodes: TraktSyncEpisodesLastActivitiesImpl = TraktSyncEpisodesLastActivitiesImpl(),
        override var shows: TraktSyncShowsLastActivitiesImpl = TraktSyncShowsLastActivitiesImpl(),
        override var seasons: TraktSyncSeasonsLastActivitiesImpl = TraktSyncSeasonsLastActivitiesImpl(),
        override var comments: TraktSyncCommentsLastActivitiesImpl = TraktSyncCommentsLastActivitiesImpl(),
        override var lists: TraktSyncListsLastActivitiesImpl = TraktSyncListsLastActivitiesImpl()
) : TraktSyncLastActivities
