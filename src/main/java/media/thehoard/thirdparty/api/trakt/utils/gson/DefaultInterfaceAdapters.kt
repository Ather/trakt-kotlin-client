package media.thehoard.thirdparty.api.trakt.utils.gson

import media.thehoard.thirdparty.api.trakt.objects.basic.*
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.TraktCalendarMovie
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.TraktCalendarShow
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations.TraktCalendarMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations.TraktCalendarShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionMovie
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShow
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowSeason
import media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionShowEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionShowSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.*
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.get.history.TraktHistoryItem
import media.thehoard.thirdparty.api.trakt.objects.get.history.implementations.TraktHistoryItemImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.*
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPerson
import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPersonIds
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.*
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.ratings.TraktRatingsItem
import media.thehoard.thirdparty.api.trakt.objects.get.ratings.implementations.TraktRatingsItemImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.*
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.get.shows.*
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.*
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.playback.TraktSyncPlaybackProgressItem
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.playback.implementations.TraktSyncPlaybackProgressItemImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.*
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktListIds
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktListItem
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListItemImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.*
import media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedMovie
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedShow
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedShowEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedShowSeason
import media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations.TraktWatchedMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations.TraktWatchedShowEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations.TraktWatchedShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations.TraktWatchedShowSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.watchlist.TraktWatchlistItem
import media.thehoard.thirdparty.api.trakt.objects.get.watchlist.implementations.TraktWatchlistItemImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.TraktCheckinPostErrorResponse
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.TraktEpisodeCheckinPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.TraktMovieCheckinPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.implementations.TraktCheckinPostErrorResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.implementations.TraktEpisodeCheckinPostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.implementations.TraktMovieCheckinPostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.comments.responses.TraktCommentPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.comments.responses.implementations.TraktCommentPostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.responses.*
import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses.TraktEpisodeScrobblePostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses.TraktMovieScrobblePostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses.implementations.TraktEpisodeScrobblePostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses.implementations.TraktMovieScrobblePostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.responses.TraktSyncCollectionPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.responses.TraktSyncCollectionRemovePostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.responses.implementations.TraktSyncCollectionPostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.responses.implementations.TraktSyncCollectionRemovePostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryRemovePostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryRemovePostResponseGroup
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryRemovePostResponseNotFoundGroup
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.implementations.TraktSyncHistoryPostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.implementations.TraktSyncHistoryRemovePostResponseGroupImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.implementations.TraktSyncHistoryRemovePostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.implementations.TraktSyncHistoryRemovePostResponseNotFoundGroupImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.*
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseGroup
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseNotFoundGroup
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.TraktSyncWatchlistPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.TraktSyncWatchlistRemovePostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.implementations.TraktSyncWatchlistPostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.implementations.TraktSyncWatchlistRemovePostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponseGroup
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponseNotFoundGroup
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsRemovePostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations.TraktUserCustomListItemsPostResponseGroupImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations.TraktUserCustomListItemsPostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations.TraktUserCustomListItemsPostResponseNotFoundGroupImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations.TraktUserCustomListItemsRemovePostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.responses.TraktUserFollowUserPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.users.responses.implementations.TraktUserFollowUserPostResponseImpl
import media.thehoard.thirdparty.api.trakt.responses.TraktListResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktNoContentResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import media.thehoard.thirdparty.api.trakt.responses.interfaces.ITraktListResponse
import media.thehoard.thirdparty.api.trakt.responses.interfaces.ITraktNoContentResponse
import media.thehoard.thirdparty.api.trakt.responses.interfaces.ITraktPagedResponse
import media.thehoard.thirdparty.api.trakt.responses.interfaces.ITraktResponse
import kotlin.reflect.KClass

internal object DefaultInterfaceAdapters {
    val adapters: Array<Pair<KClass<out Any>, InterfaceImplementationAdapter<out Any, *>>>
        get() = arrayOf(
                *Objects.basic,

                *Objects.Get.calendars,
                *Objects.Get.collections,
                *Objects.Get.episodes,
                *Objects.Get.history,
                *Objects.Get.movies,
                *Objects.Get.people,
                *Objects.Get.peopleCredits,
                *Objects.Get.ratings,
                *Objects.Get.seasons,
                *Objects.Get.shows,
                *Objects.Get.syncActivities,
                *Objects.Get.syncPlayback,
                *Objects.Get.users,
                *Objects.Get.userLists,
                *Objects.Get.userStatistics,
                *Objects.Get.watched,
                *Objects.Get.watchlist,

                *Objects.Post.checkinResponses,
                *Objects.Post.commentResponses,
                *Objects.Post.responses,
                *Objects.Post.scrobbleResponses,
                *Objects.Post.syncCollectionResponses,
                *Objects.Post.syncHistoryResponses,
                *Objects.Post.syncRatingsResponses,
                *Objects.Post.syncResponses,
                *Objects.Post.syncWatchlistResponses,
                *Objects.Post.userCustomListItemsResponses,
                *Objects.Post.usersResponses,

                //TODO Consider adding post object mappings

                * responses)

    object Objects {
        val basic = arrayOf(
                TraktCastAndCrew::class toImpl TraktCastAndCrewImpl::class,
                TraktCastMember::class toImpl TraktCastMemberImpl::class,
                TraktCertification::class toImpl TraktCertificationImpl::class,
                TraktCertifications::class toImpl TraktCertificationsImpl::class,
                TraktComment::class toImpl TraktCommentImpl::class,
                TraktCrew::class toImpl TraktCrewImpl::class,
                TraktCrewMember::class toImpl TraktCrewMemberImpl::class,
                TraktError::class toImpl TraktErrorImpl::class,
                TraktGenre::class toImpl TraktGenreImpl::class,
                TraktIds::class toImpl TraktIdsImpl::class,
                TraktImage::class toImpl TraktImageImpl::class,
                TraktMetadata::class toImpl TraktMetadataImpl::class,
                TraktNetwork::class toImpl TraktNetworkImpl::class,
                TraktRating::class toImpl TraktRatingImpl::class,
                TraktSearchResult::class toImpl TraktSearchResultImpl::class,
                TraktSharing::class toImpl TraktSharingImpl::class,
                TraktStatistics::class toImpl TraktStatisticsImpl::class,
                TraktTranslation::class toImpl TraktTranslationImpl::class
        )

        object Get {
            val calendars = arrayOf(
                    TraktCalendarMovie::class toImpl TraktCalendarMovieImpl::class,
                    TraktCalendarShow::class toImpl TraktCalendarShowImpl::class
            )

            val collections = arrayOf(
                    TraktCollectionMovie::class toImpl TraktCollectionMovieImpl::class,
                    TraktCollectionShow::class toImpl TraktCollectionShowImpl::class,
                    TraktCollectionShowEpisode::class toImpl TraktCollectionShowEpisodeImpl::class,
                    TraktCollectionShowSeason::class toImpl TraktCollectionShowSeasonImpl::class
            )

            val episodes = arrayOf(
                    TraktEpisode::class toImpl TraktEpisodeImpl::class,
                    TraktEpisodeCollectionProgress::class toImpl TraktEpisodeCollectionProgressImpl::class,
                    TraktEpisodeIds::class toImpl TraktEpisodeIdsImpl::class,
                    TraktEpisodeProgress::class toImpl TraktEpisodeProgressImpl::class,
                    TraktEpisodeTranslation::class toImpl TraktEpisodeTranslationImpl::class,
                    TraktEpisodeWatchedProgress::class toImpl TraktEpisodeWatchedProgressImpl::class
            )

            val history = arrayOf(
                    TraktHistoryItem::class toImpl TraktHistoryItemImpl::class
            )

            val movies = arrayOf(
                    TraktBoxOfficeMovie::class toImpl TraktBoxOfficeMovieImpl::class,
                    TraktMostAnticipatedMovie::class toImpl TraktMostAnticipatedMovieImpl::class,
                    TraktMostPWCMovie::class toImpl TraktMostPWCMovieImpl::class,
                    TraktMovie::class toImpl TraktMovieImpl::class,
                    TraktMovieAlias::class toImpl TraktMovieAliasImpl::class,
                    TraktMovieIds::class toImpl TraktMovieIdsImpl::class,
                    TraktMovieRelease::class toImpl TraktMovieReleaseImpl::class,
                    TraktMovieTranslation::class toImpl TraktMovieTranslationImpl::class,
                    TraktRecentlyUpdatedMovie::class toImpl TraktRecentlyUpdatedMovieImpl::class,
                    TraktTrendingMovie::class toImpl TraktTrendingMovieImpl::class
            )

            val people = arrayOf(
                    TraktPerson::class toImpl TraktPersonImpl::class,
                    TraktPersonIds::class toImpl TraktPersonIdsImpl::class
            )

            val peopleCredits = arrayOf(
                    TraktPersonMovieCredits::class toImpl TraktPersonMovieCreditsImpl::class,
                    TraktPersonMovieCreditsCastItem::class toImpl TraktPersonMovieCreditsCastItemImpl::class,
                    TraktPersonMovieCreditsCrew::class toImpl TraktPersonMovieCreditsCrewImpl::class,
                    TraktPersonMovieCreditsCrewItem::class toImpl TraktPersonMovieCreditsCrewItemImpl::class,
                    TraktPersonShowCredits::class toImpl TraktPersonShowCreditsImpl::class,
                    TraktPersonShowCreditsCastItem::class toImpl TraktPersonShowCreditsCastItemImpl::class,
                    TraktPersonShowCreditsCrew::class toImpl TraktPersonShowCreditsCrewImpl::class,
                    TraktPersonShowCreditsCrewItem::class toImpl TraktPersonShowCreditsCrewItemImpl::class
            )

            val ratings = arrayOf(
                    TraktRatingsItem::class toImpl TraktRatingsItemImpl::class
            )

            val seasons = arrayOf(
                    TraktSeason::class toImpl TraktSeasonImpl::class,
                    TraktSeasonCollectionProgress::class toImpl TraktSeasonCollectionProgressImpl::class,
                    TraktSeasonIds::class toImpl TraktSeasonIdsImpl::class,
                    TraktSeasonProgress::class toImpl TraktSeasonProgressImpl::class,
                    TraktSeasonWatchedProgress::class toImpl TraktSeasonWatchedProgressImpl::class
            )

            val shows = arrayOf(
                    TraktMostAnticipatedShow::class toImpl TraktMostAnticipatedShowImpl::class,
                    TraktMostPWCShow::class toImpl TraktMostPWCShowImpl::class,
                    TraktRecentlyUpdatedShow::class toImpl TraktRecentlyUpdatedShowImpl::class,
                    TraktShow::class toImpl TraktShowImpl::class,
                    TraktShowAirs::class toImpl TraktShowAirsImpl::class,
                    TraktShowAlias::class toImpl TraktShowAliasImpl::class,
                    TraktShowCollectionProgress::class toImpl TraktShowCollectionProgressImpl::class,
                    TraktShowIds::class toImpl TraktShowIdsImpl::class,
                    TraktShowProgress::class toImpl TraktShowProgressImpl::class,
                    TraktShowTranslation::class toImpl TraktShowTranslationImpl::class,
                    TraktShowWatchedProgress::class toImpl TraktShowWatchedProgressImpl::class,
                    TraktTrendingShow::class toImpl TraktTrendingShowImpl::class
            )

            val syncActivities = arrayOf(
                    TraktSyncCommentsLastActivities::class toImpl TraktSyncCommentsLastActivitiesImpl::class,
                    TraktSyncEpisodesLastActivities::class toImpl TraktSyncEpisodesLastActivitiesImpl::class,
                    TraktSyncLastActivities::class toImpl TraktSyncLastActivitiesImpl::class,
                    TraktSyncListsLastActivities::class toImpl TraktSyncListsLastActivitiesImpl::class,
                    TraktSyncMoviesLastActivities::class toImpl TraktSyncMoviesLastActivitiesImpl::class,
                    TraktSyncSeasonsLastActivities::class toImpl TraktSyncSeasonsLastActivitiesImpl::class,
                    TraktSyncShowsLastActivities::class toImpl TraktSyncShowsLastActivitiesImpl::class
            )

            val syncPlayback = arrayOf(
                    TraktSyncPlaybackProgressItem::class toImpl TraktSyncPlaybackProgressItemImpl::class
            )

            val users = arrayOf(
                    TraktAccountSettings::class toImpl TraktAccountSettingsImpl::class,
                    TraktSharingText::class toImpl TraktSharingTextImpl::class,
                    TraktUser::class toImpl TraktUserImpl::class,
                    TraktUserComment::class toImpl TraktUserCommentImpl::class,
                    TraktUserFollower::class toImpl TraktUserFollowerImpl::class,
                    TraktUserFollowRequest::class toImpl TraktUserFollowRequestImpl::class,
                    TraktUserFriend::class toImpl TraktUserFriendImpl::class,
                    TraktUserHiddenItem::class toImpl TraktUserHiddenItemImpl::class,
                    TraktUserIds::class toImpl TraktUserIdsImpl::class,
                    TraktUserImages::class toImpl TraktUserImagesImpl::class,
                    TraktUserLikeItem::class toImpl TraktUserLikeItemImpl::class,
                    TraktUserSettings::class toImpl TraktUserSettingsImpl::class,
                    TraktUserWatchingItem::class toImpl TraktUserWatchingItemImpl::class
            )

            val userLists = arrayOf(
                    TraktList::class toImpl TraktListImpl::class,
                    TraktListIds::class toImpl TraktListIdsImpl::class,
                    TraktListItem::class toImpl TraktListItemImpl::class
            )

            val userStatistics = arrayOf(
                    TraktUserEpisodesStatistics::class toImpl TraktUserEpisodesStatisticsImpl::class,
                    TraktUserMoviesStatistics::class toImpl TraktUserMoviesStatisticsImpl::class,
                    TraktUserNetworkStatistics::class toImpl TraktUserNetworkStatisticsImpl::class,
                    TraktUserRatingsStatistics::class toImpl TraktUserRatingsStatisticsImpl::class,
                    TraktUserSeasonsStatistics::class toImpl TraktUserSeasonsStatisticsImpl::class,
                    TraktUserShowsStatistics::class toImpl TraktUserShowsStatisticsImpl::class,
                    TraktUserStatistics::class toImpl TraktUserStatisticsImpl::class
            )

            val watched = arrayOf(
                    TraktWatchedMovie::class toImpl TraktWatchedMovieImpl::class,
                    TraktWatchedShow::class toImpl TraktWatchedShowImpl::class,
                    TraktWatchedShowEpisode::class toImpl TraktWatchedShowEpisodeImpl::class,
                    TraktWatchedShowSeason::class toImpl TraktWatchedShowSeasonImpl::class
            )

            val watchlist = arrayOf(
                    TraktWatchlistItem::class toImpl TraktWatchlistItemImpl::class
            )
        }

        object Post {
            val checkinResponses = arrayOf(
                    TraktCheckinPostErrorResponse::class toImpl TraktCheckinPostErrorResponseImpl::class,
                    TraktEpisodeCheckinPostResponse::class toImpl TraktEpisodeCheckinPostResponseImpl::class,
                    TraktMovieCheckinPostResponse::class toImpl TraktMovieCheckinPostResponseImpl::class
            )

            val commentResponses = arrayOf(
                    TraktCommentPostResponse::class toImpl TraktCommentPostResponseImpl::class
            )

            val responses = arrayOf(
                    TraktPostResponseNotFoundEpisode::class toImpl TraktPostResponseNotFoundEpisodeImpl::class,
                    TraktPostResponseNotFoundMovie::class toImpl TraktPostResponseNotFoundMovieImpl::class,
                    TraktPostResponseNotFoundPerson::class toImpl TraktPostResponseNotFoundPersonImpl::class,
                    TraktPostResponseNotFoundSeason::class toImpl TraktPostResponseNotFoundSeasonImpl::class,
                    TraktPostResponseNotFoundShow::class toImpl TraktPostResponseNotFoundShowImpl::class
            )

            val scrobbleResponses = arrayOf(
                    TraktEpisodeScrobblePostResponse::class toImpl TraktEpisodeScrobblePostResponseImpl::class,
                    TraktMovieScrobblePostResponse::class toImpl TraktMovieScrobblePostResponseImpl::class
            )

            val syncCollectionResponses = arrayOf(
                    TraktSyncCollectionPostResponse::class toImpl TraktSyncCollectionPostResponseImpl::class,
                    TraktSyncCollectionRemovePostResponse::class toImpl TraktSyncCollectionRemovePostResponseImpl::class
            )

            val syncHistoryResponses = arrayOf(
                    TraktSyncHistoryPostResponse::class toImpl TraktSyncHistoryPostResponseImpl::class,
                    TraktSyncHistoryRemovePostResponse::class toImpl TraktSyncHistoryRemovePostResponseImpl::class,
                    TraktSyncHistoryRemovePostResponseGroup::class toImpl TraktSyncHistoryRemovePostResponseGroupImpl::class,
                    TraktSyncHistoryRemovePostResponseNotFoundGroup::class toImpl TraktSyncHistoryRemovePostResponseNotFoundGroupImpl::class
            )

            val syncRatingsResponses = arrayOf(
                    TraktSyncRatingsPostResponse::class toImpl TraktSyncRatingsPostResponseImpl::class,
                    TraktSyncRatingsPostResponseNotFoundEpisode::class toImpl TraktSyncRatingsPostResponseNotFoundEpisodeImpl::class,
                    TraktSyncRatingsPostResponseNotFoundGroup::class toImpl TraktSyncRatingsPostResponseNotFoundGroupImpl::class,
                    TraktSyncRatingsPostResponseNotFoundMovie::class toImpl TraktSyncRatingsPostResponseNotFoundMovieImpl::class,
                    TraktSyncRatingsPostResponseNotFoundSeason::class toImpl TraktSyncRatingsPostResponseNotFoundSeasonImpl::class,
                    TraktSyncRatingsPostResponseNotFoundShow::class toImpl TraktSyncRatingsPostResponseNotFoundShowImpl::class,
                    TraktSyncRatingsRemovePostResponse::class toImpl TraktSyncRatingsRemovePostResponseImpl::class
            )

            val syncResponses = arrayOf(
                    TraktSyncPostResponseGroup::class toImpl TraktSyncPostResponseGroupImpl::class,
                    TraktSyncPostResponseNotFoundGroup::class toImpl TraktSyncPostResponseNotFoundGroupImpl::class
            )

            val syncWatchlistResponses = arrayOf(
                    TraktSyncWatchlistPostResponse::class toImpl TraktSyncWatchlistPostResponseImpl::class,
                    TraktSyncWatchlistRemovePostResponse::class toImpl TraktSyncWatchlistRemovePostResponseImpl::class
            )

            val userCustomListItemsResponses = arrayOf(
                    TraktUserCustomListItemsPostResponse::class toImpl TraktUserCustomListItemsPostResponseImpl::class,
                    TraktUserCustomListItemsPostResponseGroup::class toImpl TraktUserCustomListItemsPostResponseGroupImpl::class,
                    TraktUserCustomListItemsPostResponseNotFoundGroup::class toImpl TraktUserCustomListItemsPostResponseNotFoundGroupImpl::class,
                    TraktUserCustomListItemsRemovePostResponse::class toImpl TraktUserCustomListItemsRemovePostResponseImpl::class
            )

            val usersResponses = arrayOf(
                    TraktUserFollowUserPostResponse::class toImpl TraktUserFollowUserPostResponseImpl::class
            )
        }
    }

    val responses = arrayOf(
            ITraktListResponse::class toImpl TraktListResponse::class,
            ITraktNoContentResponse::class toImpl TraktNoContentResponse::class,
            ITraktPagedResponse::class toImpl TraktPagedResponse::class,
            ITraktResponse::class toImpl TraktResponse::class
    )
}