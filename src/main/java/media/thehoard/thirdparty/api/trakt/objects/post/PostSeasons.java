package media.thehoard.thirdparty.api.trakt.objects.post;

import java.util.*;

public final class PostSeasons implements Collection<PostSeasons.PostSeason> {
	private final List<PostSeason> seasons;

	public PostSeasons() {
		this.seasons = new ArrayList<>();
	}

	public boolean add(int season) {
		return seasons.add(new PostSeason(season));
	}

	public boolean add(int season, PostEpisodes episodes) {
		return seasons.add(new PostSeason(season, episodes));
	}

	@Override
	public int size() {
		return seasons.size();
	}

	@Override
	public boolean isEmpty() {
		return seasons.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return seasons.contains(o);
	}

	@Override
	public Iterator<PostSeason> iterator() {
		return seasons.iterator();
	}

	@Override
	public Object[] toArray() {
		return seasons.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return seasons.toArray(a);
	}

	@Override
	public boolean add(PostSeason postSeason) {
		return add(postSeason.number, postSeason.episodes);
	}

	@Override
	public boolean remove(Object o) {
		return seasons.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return seasons.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends PostSeason> c) {
		return seasons.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return seasons.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return seasons.retainAll(c);
	}

	@Override
	public void clear() {
		seasons.clear();
	}

	public final class PostSeason {
		public int number;

		public PostEpisodes episodes;

		public PostSeason(int number, PostEpisodes episodes) {
			this.number = number;
			this.episodes = episodes;
		}

		public PostSeason(int number) {
			this(number, new PostEpisodes());
		}

		public PostSeason() {
			this(-1);
		}
	}

	public final class PostEpisodes implements Collection<Integer> {
		//TODO Verify that this will not need to be serialized
		private final List<Integer> episodes;

		public PostEpisodes() {
			this.episodes = new ArrayList<>();
		}

		public void add(int episode, Integer... episodes) {
			this.episodes.add(episode);

			this.episodes.addAll(Arrays.asList(episodes));
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
		public Iterator<Integer> iterator() {
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
		public boolean add(Integer integer) {
			return episodes.add(integer);
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
		public boolean addAll(Collection<? extends Integer> c) {
			return episodes.addAll(c);
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			return episodes.removeAll(c);
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			return episodes.removeAll(c);
		}

		@Override
		public void clear() {
			episodes.clear();
		}
	}
}
