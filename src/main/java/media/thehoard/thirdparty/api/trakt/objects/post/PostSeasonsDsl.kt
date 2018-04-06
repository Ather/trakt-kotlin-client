package media.thehoard.thirdparty.api.trakt.objects.post

import java.time.ZonedDateTime

@PostSeasonsDsl
fun seasons(block: PostSeasons.() -> Unit): PostSeasons = PostSeasons().apply(block)

@PostSeasonsDsl
fun ratingsSeasons(block: PostRatingsSeasons.() -> Unit): PostRatingsSeasons = PostRatingsSeasons().apply(block)

@PostSeasonsDsl
fun historySeasons(block: PostHistorySeasons.() -> Unit): PostHistorySeasons = PostHistorySeasons().apply(block)

@PostSeasonDsl
fun PostSeasons.season(block: PostSeasonBuilder.() -> Unit) = PostSeasonBuilder().apply(block).build()

@PostSeasonDsl
fun PostRatingsSeasons.season(block: PostRatingsSeasonBuilder.() -> Unit) = PostRatingsSeasonBuilder().apply(block).build()

@PostSeasonDsl
fun PostHistorySeasons.season(block: PostHistorySeasonBuilder.() -> Unit) = PostHistorySeasonBuilder().apply(block).build()

@PostEpisodeDsl
fun PostSeason.episode(item: Int) = item

@PostEpisodeDsl
fun PostRatingsSeason.episode(block: PostRatingsEpisode.() -> Unit): PostRatingsEpisode = PostRatingsEpisode().apply(block)

@PostEpisodeDsl
fun PostHistorySeason.episode(block: PostHistoryEpisode.() -> Unit): PostHistoryEpisode = PostHistoryEpisode().apply(block)

@PostSeasonsDsl
class PostSeasonBuilder {

    var number: Int = -1

    private val episodes = mutableListOf<Int>()

    fun episode(int: Int) = episodes.add(int)

    fun build(): PostSeason = PostSeason(number, PostEpisodes(*episodes.toIntArray()))
}

@PostSeasonsDsl
class PostRatingsSeasonBuilder {

    var number: Int = -1
    var rating: Int? = null
    var ratedAt: ZonedDateTime? = null

    private val episodes = mutableListOf<PostRatingsEpisode>()

    fun episode(block: PostRatingsEpisode.() -> Unit) = episodes.add(PostRatingsEpisode().apply(block))

    fun build(): PostRatingsSeason = PostRatingsSeason(number, rating, ratedAt, PostRatingsEpisodes(*episodes.toTypedArray()))
}

@PostSeasonsDsl
class PostHistorySeasonBuilder {

    var number: Int = -1
    var watchedAt: ZonedDateTime? = null

    private val episodes = mutableListOf<PostHistoryEpisode>()

    fun episode(block: PostHistoryEpisode.() -> Unit) = episodes.add(PostHistoryEpisode().apply(block))

    fun build(): PostHistorySeason = PostHistorySeason(number, watchedAt, PostHistoryEpisodes(*episodes.toTypedArray()))
}

@DslMarker
annotation class PostSeasonsDsl

@DslMarker
annotation class PostSeasonDsl

@DslMarker
annotation class PostEpisodeDsl