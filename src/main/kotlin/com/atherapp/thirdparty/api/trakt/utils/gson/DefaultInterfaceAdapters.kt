package com.atherapp.thirdparty.api.trakt.utils.gson

import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktDevice
import com.atherapp.thirdparty.api.trakt.objects.authentication.implementations.TraktAuthorizationImpl
import com.atherapp.thirdparty.api.trakt.objects.authentication.implementations.TraktDeviceImpl
import com.atherapp.thirdparty.api.trakt.objects.basic.*
import com.atherapp.thirdparty.api.trakt.objects.basic.implementations.*
import com.atherapp.thirdparty.api.trakt.objects.get.calendars.TraktCalendarMovie
import com.atherapp.thirdparty.api.trakt.objects.get.calendars.TraktCalendarShow
import com.atherapp.thirdparty.api.trakt.objects.get.calendars.implementations.TraktCalendarMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.get.calendars.implementations.TraktCalendarShowImpl
import com.atherapp.thirdparty.api.trakt.objects.get.collections.TraktCollectionMovie
import com.atherapp.thirdparty.api.trakt.objects.get.collections.TraktCollectionShow
import com.atherapp.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowSeason
import com.atherapp.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionShowEpisodeImpl
import com.atherapp.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionShowImpl
import com.atherapp.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionShowSeasonImpl
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.*
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.*
import com.atherapp.thirdparty.api.trakt.objects.get.history.TraktHistoryItem
import com.atherapp.thirdparty.api.trakt.objects.get.history.implementations.TraktHistoryItemImpl
import com.atherapp.thirdparty.api.trakt.objects.get.movies.*
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.*
import com.atherapp.thirdparty.api.trakt.objects.get.people.TraktPerson
import com.atherapp.thirdparty.api.trakt.objects.get.people.credits.*
import com.atherapp.thirdparty.api.trakt.objects.get.people.credits.implementations.*
import com.atherapp.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl
import com.atherapp.thirdparty.api.trakt.objects.get.ratings.TraktRatingsItem
import com.atherapp.thirdparty.api.trakt.objects.get.ratings.implementations.TraktRatingsItemImpl
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeasonCollectionProgress
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeasonProgress
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeasonWatchedProgress
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonCollectionProgressImpl
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonProgressImpl
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonWatchedProgressImpl
import com.atherapp.thirdparty.api.trakt.objects.get.shows.*
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.*
import com.atherapp.thirdparty.api.trakt.objects.get.syncs.activities.*
import com.atherapp.thirdparty.api.trakt.objects.get.syncs.activities.implementations.*
import com.atherapp.thirdparty.api.trakt.objects.get.syncs.playback.TraktSyncPlaybackProgressItem
import com.atherapp.thirdparty.api.trakt.objects.get.syncs.playback.implementations.TraktSyncPlaybackProgressItemImpl
import com.atherapp.thirdparty.api.trakt.objects.get.users.*
import com.atherapp.thirdparty.api.trakt.objects.get.users.implementations.*
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktListItem
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListItemImpl
import com.atherapp.thirdparty.api.trakt.objects.get.users.statistics.*
import com.atherapp.thirdparty.api.trakt.objects.get.users.statistics.implementations.*
import com.atherapp.thirdparty.api.trakt.objects.get.watched.TraktWatchedMovie
import com.atherapp.thirdparty.api.trakt.objects.get.watched.TraktWatchedShow
import com.atherapp.thirdparty.api.trakt.objects.get.watched.TraktWatchedShowEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.watched.TraktWatchedShowSeason
import com.atherapp.thirdparty.api.trakt.objects.get.watched.implementations.TraktWatchedMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.get.watched.implementations.TraktWatchedShowEpisodeImpl
import com.atherapp.thirdparty.api.trakt.objects.get.watched.implementations.TraktWatchedShowImpl
import com.atherapp.thirdparty.api.trakt.objects.get.watched.implementations.TraktWatchedShowSeasonImpl
import com.atherapp.thirdparty.api.trakt.objects.get.watchlist.TraktWatchlistItem
import com.atherapp.thirdparty.api.trakt.objects.get.watchlist.implementations.TraktWatchlistItemImpl
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.TraktCheckinPostErrorResponse
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.TraktEpisodeCheckinPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.TraktMovieCheckinPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.implementations.TraktCheckinPostErrorResponseImpl
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.implementations.TraktEpisodeCheckinPostResponseImpl
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.implementations.TraktMovieCheckinPostResponseImpl
import com.atherapp.thirdparty.api.trakt.objects.post.comments.responses.TraktCommentPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.comments.responses.implementations.TraktCommentPostResponseImpl
import com.atherapp.thirdparty.api.trakt.objects.post.responses.*
import com.atherapp.thirdparty.api.trakt.objects.post.responses.implementations.*
import com.atherapp.thirdparty.api.trakt.objects.post.scrobbles.responses.TraktEpisodeScrobblePostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.scrobbles.responses.TraktMovieScrobblePostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.scrobbles.responses.implementations.TraktEpisodeScrobblePostResponseImpl
import com.atherapp.thirdparty.api.trakt.objects.post.scrobbles.responses.implementations.TraktMovieScrobblePostResponseImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.responses.TraktSyncCollectionPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.responses.TraktSyncCollectionRemovePostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.responses.implementations.TraktSyncCollectionPostResponseImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.responses.implementations.TraktSyncCollectionRemovePostResponseImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryRemovePostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryRemovePostResponseGroup
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryRemovePostResponseNotFoundGroup
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses.implementations.TraktSyncHistoryPostResponseImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses.implementations.TraktSyncHistoryRemovePostResponseGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses.implementations.TraktSyncHistoryRemovePostResponseImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses.implementations.TraktSyncHistoryRemovePostResponseNotFoundGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.*
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations.*
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseGroup
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseNotFoundGroup
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.TraktSyncWatchlistPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.TraktSyncWatchlistRemovePostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.implementations.TraktSyncWatchlistPostResponseImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.implementations.TraktSyncWatchlistRemovePostResponseImpl
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponseGroup
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponseNotFoundGroup
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsRemovePostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations.TraktUserCustomListItemsPostResponseGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations.TraktUserCustomListItemsPostResponseImpl
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations.TraktUserCustomListItemsPostResponseNotFoundGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations.TraktUserCustomListItemsRemovePostResponseImpl
import com.atherapp.thirdparty.api.trakt.objects.post.users.responses.TraktUserFollowUserPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.users.responses.implementations.TraktUserFollowUserPostResponseImpl
import com.atherapp.thirdparty.api.trakt.responses.TraktListResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktNoContentResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktPagedResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import com.atherapp.thirdparty.api.trakt.responses.interfaces.ITraktListResponse
import com.atherapp.thirdparty.api.trakt.responses.interfaces.ITraktNoContentResponse
import com.atherapp.thirdparty.api.trakt.responses.interfaces.ITraktPagedResponse
import com.atherapp.thirdparty.api.trakt.responses.interfaces.ITraktResponse
import kotlin.reflect.KClass

internal object DefaultInterfaceAdapters {
    val adapters: Array<Pair<KClass<out Any>, InterfaceImplementationAdapter<out Any, *>>>
        get() = arrayOf(
                *Objects.authentication,

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
        val authentication = arrayOf(
                TraktAuthorization::class toImpl TraktAuthorizationImpl::class,
                TraktDevice::class toImpl TraktDeviceImpl::class
        )

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
                    TraktMovieRelease::class toImpl TraktMovieReleaseImpl::class,
                    TraktMovieTranslation::class toImpl TraktMovieTranslationImpl::class,
                    TraktRecentlyUpdatedMovie::class toImpl TraktRecentlyUpdatedMovieImpl::class,
                    TraktTrendingMovie::class toImpl TraktTrendingMovieImpl::class
            )

            val people = arrayOf(
                    TraktPerson::class toImpl TraktPersonImpl::class
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
                    TraktUserImages::class toImpl TraktUserImagesImpl::class,
                    TraktUserLikeItem::class toImpl TraktUserLikeItemImpl::class,
                    TraktUserSettings::class toImpl TraktUserSettingsImpl::class,
                    TraktUserWatchingItem::class toImpl TraktUserWatchingItemImpl::class
            )

            val userLists = arrayOf(
                    TraktList::class toImpl TraktListImpl::class,
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