package media.thehoard.thirdparty.api.trakt.objects.post

@PostSeasonsDsl
class PostSeasons(vararg seasons: PostSeason = arrayOf()) : MutableCollection<PostSeason> {
    private val seasons: MutableList<PostSeason> = seasons.toMutableList()

    override val size: Int
        get() = seasons.size

    override fun add(element: PostSeason): Boolean = add(element.number, element.episodes)

    fun add(season: Int, episodes: PostEpisodes = PostEpisodes()): Boolean = seasons.add(PostSeason(season, episodes))

    override fun contains(element: PostSeason): Boolean = seasons.contains(element)
    override fun containsAll(elements: Collection<PostSeason>): Boolean = seasons.containsAll(elements)
    override fun isEmpty(): Boolean = seasons.isEmpty()
    override fun addAll(elements: Collection<PostSeason>): Boolean = seasons.addAll(elements)
    override fun clear() = seasons.clear()
    override fun iterator(): MutableIterator<PostSeason> = seasons.iterator()
    override fun remove(element: PostSeason): Boolean = seasons.remove(element)
    override fun removeAll(elements: Collection<PostSeason>): Boolean = seasons.removeAll(elements)
    override fun retainAll(elements: Collection<PostSeason>): Boolean = seasons.retainAll(elements)
}

@PostSeasonDsl
class PostSeason(var number: Int = -1, var episodes: PostEpisodes = PostEpisodes())

class PostEpisodes(vararg episodes: Int = intArrayOf()) : MutableCollection<Int> {
    private val episodes: MutableList<Int> = episodes.toMutableList()

    override val size: Int
        get() = episodes.size

    override fun add(element: Int): Boolean = episodes.add(element)
    fun add(vararg episodes: Int) = this.episodes.addAll(episodes.asSequence())

    override fun contains(element: Int): Boolean = episodes.contains(element)
    override fun containsAll(elements: Collection<Int>): Boolean = episodes.containsAll(elements)
    override fun isEmpty(): Boolean = episodes.isEmpty()
    override fun addAll(elements: Collection<Int>): Boolean = episodes.addAll(elements)
    override fun clear() = episodes.clear()
    override fun iterator(): MutableIterator<Int> = episodes.iterator()
    override fun remove(element: Int): Boolean = episodes.remove(element)
    override fun removeAll(elements: Collection<Int>): Boolean = episodes.removeAll(elements)
    override fun retainAll(elements: Collection<Int>): Boolean = episodes.retainAll(elements)
}
