package media.thehoard.thirdparty.api.trakt.objects.post;

import com.google.gson.annotations.SerializedName;

import java.util.*;

public final class PostRatingsEpisodes implements Collection<PostRatingsEpisodes.PostRatingsEpisode> {
	private final List<PostRatingsEpisode> episodes;

	public PostRatingsEpisodes() {
		this.episodes = new ArrayList<>();
	}

	public void add(PostRatingsEpisode episode, PostRatingsEpisode... episodes) {
		this.episodes.add(episode);

		this.episodes.addAll(Arrays.asList(episodes));
	}

	public void add(int episode, int rating, Date ratedAt) {
		episodes.add(new PostRatingsEpisode(episode, rating, ratedAt));
	}

	public void add(int episode, int rating) {
		episodes.add(new PostRatingsEpisode(episode, rating, null));
	}

	public void add(int episode) {
		episodes.add(new PostRatingsEpisode(episode));
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
	public Iterator<PostRatingsEpisode> iterator() {
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
	public boolean add(PostRatingsEpisode postRatingsEpisode) {
		return episodes.add(postRatingsEpisode);
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
	public boolean addAll(Collection<? extends PostRatingsEpisode> c) {
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

	public final class PostRatingsEpisode {
		public PostRatingsEpisode(int number, Integer rating, Date ratedAt) {
			this.number = number;
			this.rating = rating;
			this.ratedAt = ratedAt;
		}

		public PostRatingsEpisode(int number, Integer rating) {
			this(number, rating, null);
		}

		public PostRatingsEpisode(int number) {
			this(number, null);
		}

		public PostRatingsEpisode() {
			this(-1);
		}

		public int number;

		public Integer rating;

		@SerializedName("rated_at")
		public Date ratedAt;
	}
}
