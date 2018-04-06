package media.thehoard.thirdparty.api.trakt.objects.post

import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime

class PostHistorySeasons(vararg seasons: PostHistorySeason = arrayOf()) : MutableList<PostHistorySeason> {
    private val seasons: MutableList<PostHistorySeason> = seasons.toMutableList()

    override val size: Int
        get() = seasons.size

    fun add(season: Int, watchedAt: ZonedDateTime? = null, episodes: PostHistoryEpisodes = PostHistoryEpisodes()) {
        seasons.add(PostHistorySeason(season, watchedAt, episodes))
    }

    override fun contains(element: PostHistorySeason): Boolean = seasons.contains(element)
    override fun containsAll(elements: Collection<PostHistorySeason>): Boolean = seasons.containsAll(elements)
    override fun isEmpty(): Boolean = seasons.isEmpty()
    override fun addAll(elements: Collection<PostHistorySeason>): Boolean = seasons.addAll(elements)
    override fun clear() = seasons.clear()
    override fun iterator(): MutableIterator<PostHistorySeason> = seasons.iterator()
    override fun remove(element: PostHistorySeason): Boolean = seasons.remove(element)
    override fun removeAll(elements: Collection<PostHistorySeason>): Boolean = seasons.removeAll(elements)
    override fun retainAll(elements: Collection<PostHistorySeason>): Boolean = seasons.retainAll(elements)
    override fun get(index: Int): PostHistorySeason = seasons[index]
    override fun indexOf(element: PostHistorySeason): Int = seasons.indexOf(element)
    override fun lastIndexOf(element: PostHistorySeason): Int = seasons.lastIndexOf(element)
    override fun add(element: PostHistorySeason): Boolean = seasons.add(element)
    override fun add(index: Int, element: PostHistorySeason) = seasons.add(index, element)
    override fun addAll(index: Int, elements: Collection<PostHistorySeason>): Boolean = seasons.addAll(index, elements)
    override fun listIterator(): MutableListIterator<PostHistorySeason> = seasons.listIterator()
    override fun listIterator(index: Int): MutableListIterator<PostHistorySeason> = seasons.listIterator(index)
    override fun removeAt(index: Int): PostHistorySeason = seasons.removeAt(index)
    override fun set(index: Int, element: PostHistorySeason): PostHistorySeason = seasons.set(index, element)
    override fun subList(fromIndex: Int, toIndex: Int): MutableList<PostHistorySeason> = subList(fromIndex, toIndex)
}

@PostSeasonDsl
class PostHistorySeason(
        var number: Int = -1,
        @SerializedName("watched_at")
        var watchedAt: ZonedDateTime? = null,
        var episodes: PostHistoryEpisodes = PostHistoryEpisodes()
)

class PostHistoryEpisodes(vararg episodes: PostHistoryEpisode = arrayOf()) : MutableList<PostHistoryEpisode> {
    private val episodes: MutableList<PostHistoryEpisode> = episodes.toMutableList()

    override val size: Int
        get() = episodes.size

    fun add(vararg episodes: PostHistoryEpisode) = this.episodes.addAll(episodes.asSequence())

    fun add(episode: Int, watchedAt: ZonedDateTime? = null) {
        add(PostHistoryEpisode(episode, watchedAt))
    }

    override fun contains(element: PostHistoryEpisode): Boolean = episodes.contains(element)
    override fun containsAll(elements: Collection<PostHistoryEpisode>): Boolean = episodes.containsAll(elements)
    override fun isEmpty(): Boolean = episodes.isEmpty()
    override fun addAll(elements: Collection<PostHistoryEpisode>): Boolean = episodes.addAll(elements)
    override fun clear() = episodes.clear()
    override fun iterator(): MutableIterator<PostHistoryEpisode> = episodes.iterator()
    override fun remove(element: PostHistoryEpisode): Boolean = episodes.remove(element)
    override fun removeAll(elements: Collection<PostHistoryEpisode>): Boolean = episodes.removeAll(elements)
    override fun retainAll(elements: Collection<PostHistoryEpisode>): Boolean = episodes.retainAll(elements)
    override fun get(index: Int): PostHistoryEpisode = episodes[index]
    override fun indexOf(element: PostHistoryEpisode): Int = episodes.indexOf(element)
    override fun lastIndexOf(element: PostHistoryEpisode): Int = episodes.lastIndexOf(element)
    override fun add(element: PostHistoryEpisode): Boolean = episodes.add(element)
    override fun add(index: Int, element: PostHistoryEpisode) = episodes.add(index, element)
    override fun addAll(index: Int, elements: Collection<PostHistoryEpisode>): Boolean = episodes.addAll(index, elements)
    override fun listIterator(): MutableListIterator<PostHistoryEpisode> = episodes.listIterator()
    override fun listIterator(index: Int): MutableListIterator<PostHistoryEpisode> = episodes.listIterator(index)
    override fun removeAt(index: Int): PostHistoryEpisode = episodes.removeAt(index)
    override fun set(index: Int, element: PostHistoryEpisode): PostHistoryEpisode = episodes.set(index, element)
    override fun subList(fromIndex: Int, toIndex: Int): MutableList<PostHistoryEpisode> = subList(fromIndex, toIndex)
}

class PostHistoryEpisode(
        var number: Int = -1,
        @SerializedName("watched_at")
        var watchedAt: ZonedDateTime? = null
)