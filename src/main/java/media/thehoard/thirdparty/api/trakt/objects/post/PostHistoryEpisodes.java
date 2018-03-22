package media.thehoard.thirdparty.api.trakt.objects.post;

import com.google.gson.annotations.SerializedName;

import java.util.*;

public final class PostHistoryEpisodes implements Collection<PostHistoryEpisodes.PostHistoryEpisode> {
	private final List<PostHistoryEpisode> episodes;

	public PostHistoryEpisodes() {
		this.episodes = new ArrayList<>();
	}

	public void add(PostHistoryEpisode episode, PostHistoryEpisode... episodes) {
		this.episodes.add(episode);

		this.episodes.addAll(Arrays.asList(episodes));
	}

	public void add(int episode, Date watchedAt) {
		add(new PostHistoryEpisode(episode, watchedAt));
	}

	public void add(int episode) {
		add(episode, null);
	}

	@Override
	public int size() {
		return episodes.size();
	}

	@Override
	public boolean isEmpty() {
		return episodes.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return episodes.contains(o);
	}

	@Override
	public Iterator<PostHistoryEpisode> iterator() {
		return episodes.iterator();
	}

	@Override
	public Object[] toArray() {
		return episodes.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return episodes.toArray(a);
	}

	@Override
	public boolean add(PostHistoryEpisode postHistoryEpisode) {
		return episodes.add(postHistoryEpisode);
	}

	@Override
	public boolean remove(Object o) {
		return episodes.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return episodes.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends PostHistoryEpisode> c) {
		return episodes.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return episodes.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return episodes.retainAll(c);
	}

	@Override
	public void clear() {
		episodes.clear();
	}

	public final class PostHistoryEpisode {
		public int number;

		@SerializedName("watched_at")
		public Date watchedAt;

		public PostHistoryEpisode(int number, Date watchedAt) {
			this.number = number;
			this.watchedAt = watchedAt;
		}

		public PostHistoryEpisode(int number) {
			this(number, null);
		}

		public PostHistoryEpisode() {
			this(-1);
		}
	}
}
