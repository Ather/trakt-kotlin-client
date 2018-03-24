package media.thehoard.thirdparty.api.trakt.objects.post

import com.google.gson.annotations.SerializedName
import java.time.Instant

class PostRatingsSeasons(vararg seasons: PostRatingsSeason = arrayOf()) : MutableList<PostRatingsSeason> {

    private val seasons: MutableList<PostRatingsSeason> = seasons.toMutableList()

    override val size: Int
        get() = seasons.size


    fun add(season: Int, rating: Int? = null, ratedAt: Instant? = null, episodes: PostRatingsEpisodes = PostRatingsEpisodes()) {
        seasons.add(PostRatingsSeason(season, rating, ratedAt, episodes))
    }

    override fun contains(element: PostRatingsSeason): Boolean = seasons.contains(element)
    override fun containsAll(elements: Collection<PostRatingsSeason>): Boolean = seasons.containsAll(elements)
    override fun isEmpty(): Boolean = seasons.isEmpty()
    override fun addAll(elements: Collection<PostRatingsSeason>): Boolean = seasons.addAll(elements)
    override fun clear() = seasons.clear()
    override fun iterator(): MutableIterator<PostRatingsSeason> = seasons.iterator()
    override fun remove(element: PostRatingsSeason): Boolean = seasons.remove(element)
    override fun removeAll(elements: Collection<PostRatingsSeason>): Boolean = seasons.removeAll(elements)
    override fun retainAll(elements: Collection<PostRatingsSeason>): Boolean = seasons.retainAll(elements)
    override fun get(index: Int): PostRatingsSeason = seasons[index]
    override fun indexOf(element: PostRatingsSeason): Int = seasons.indexOf(element)
    override fun lastIndexOf(element: PostRatingsSeason): Int = seasons.lastIndexOf(element)
    override fun add(element: PostRatingsSeason): Boolean = seasons.add(element)
    override fun add(index: Int, element: PostRatingsSeason) = seasons.add(index, element)
    override fun addAll(index: Int, elements: Collection<PostRatingsSeason>): Boolean = seasons.addAll(index, elements)
    override fun listIterator(): MutableListIterator<PostRatingsSeason> = seasons.listIterator()
    override fun listIterator(index: Int): MutableListIterator<PostRatingsSeason> = seasons.listIterator(index)
    override fun removeAt(index: Int): PostRatingsSeason = seasons.removeAt(index)
    override fun set(index: Int, element: PostRatingsSeason): PostRatingsSeason = seasons.set(index, element)
    override fun subList(fromIndex: Int, toIndex: Int): MutableList<PostRatingsSeason> = subList(fromIndex, toIndex)
}

class PostRatingsSeason(
        var number: Int = -1,
        var rating: Int? = null,
        @SerializedName("rated_at")
        var ratedAt: Instant? = null,
        var episodes: PostRatingsEpisodes = PostRatingsEpisodes()
)

class PostRatingsEpisodes(vararg episodes: PostRatingsEpisode = arrayOf()) : MutableList<PostRatingsEpisode> {

    private val episodes: MutableList<PostRatingsEpisode> = episodes.toMutableList()

    override val size: Int
        get() = episodes.size

    fun add(vararg episodes: PostRatingsEpisode) = this.episodes.addAll(episodes.asSequence())

    fun add(episode: Int, rating: Int? = null, ratedAt: Instant? = null) {
        episodes.add(PostRatingsEpisode(episode, rating, ratedAt))
    }

    override fun contains(element: PostRatingsEpisode): Boolean = episodes.contains(element)
    override fun containsAll(elements: Collection<PostRatingsEpisode>): Boolean = episodes.containsAll(elements)
    override fun isEmpty(): Boolean = episodes.isEmpty()
    override fun addAll(elements: Collection<PostRatingsEpisode>): Boolean = episodes.addAll(elements)
    override fun clear() = episodes.clear()
    override fun iterator(): MutableIterator<PostRatingsEpisode> = episodes.iterator()
    override fun remove(element: PostRatingsEpisode): Boolean = episodes.remove(element)
    override fun removeAll(elements: Collection<PostRatingsEpisode>): Boolean = episodes.removeAll(elements)
    override fun retainAll(elements: Collection<PostRatingsEpisode>): Boolean = episodes.retainAll(elements)
    override fun get(index: Int): PostRatingsEpisode = episodes[index]
    override fun indexOf(element: PostRatingsEpisode): Int = episodes.indexOf(element)
    override fun lastIndexOf(element: PostRatingsEpisode): Int = episodes.lastIndexOf(element)
    override fun add(element: PostRatingsEpisode): Boolean = episodes.add(element)
    override fun add(index: Int, element: PostRatingsEpisode) = episodes.add(index, element)
    override fun addAll(index: Int, elements: Collection<PostRatingsEpisode>): Boolean = episodes.addAll(index, elements)
    override fun listIterator(): MutableListIterator<PostRatingsEpisode> = episodes.listIterator()
    override fun listIterator(index: Int): MutableListIterator<PostRatingsEpisode> = episodes.listIterator(index)
    override fun removeAt(index: Int): PostRatingsEpisode = episodes.removeAt(index)
    override fun set(index: Int, element: PostRatingsEpisode): PostRatingsEpisode = episodes.set(index, element)
    override fun subList(fromIndex: Int, toIndex: Int): MutableList<PostRatingsEpisode> = subList(fromIndex, toIndex)
}

class PostRatingsEpisode(
        var number: Int = -1,
        var rating: Int? = null,
        @SerializedName("rated_at")
        var ratedAt: Instant? = null
)
