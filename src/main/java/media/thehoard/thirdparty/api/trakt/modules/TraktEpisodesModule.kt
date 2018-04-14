package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.requests.episodes.EpisodeSummaryRequest
import media.thehoard.thirdparty.api.trakt.requests.handler.RequestHandler
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.util.concurrent.CompletableFuture

class TraktEpisodesModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getEpisodeAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int,
            extendedInfo: TraktExtendedInfo? = null
    ): CompletableFuture<TraktResponse<TraktEpisode>> {
        return RequestHandler(client).executeSingleItemRequestAsync(EpisodeSummaryRequest(
                id = showIdOrSlug,
                seasonNumber = seasonNumber,
                episodeNumber = episodeNumber,
                extendedInfo = extendedInfo
        ))
    }

    /*fun getMultipleEpisodesAsync(
            episodesQueryParams: TraktMultipleEpisodesQueryParams
    )*/
}