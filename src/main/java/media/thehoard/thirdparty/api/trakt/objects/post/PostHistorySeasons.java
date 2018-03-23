package media.thehoard.thirdparty.api.trakt.objects.post;

import com.google.gson.annotations.SerializedName;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class PostHistorySeasons implements Iterable<PostHistorySeasons.PostHistorySeason> {
	private final List<PostHistorySeason> seasons;

	public PostHistorySeasons() {
		this.seasons = new ArrayList<>();
	}

	public void add(int season, Instant watchedAt, PostHistoryEpisodes episodes) {
		seasons.add(new PostHistorySeason(season, watchedAt, episodes));
	}

	public void add(int season, Instant watchedAt) {
		this.seasons.add(new PostHistorySeason(season, watchedAt));
	}

	public void add(int season, PostHistoryEpisodes episodes) {
		seasons.add(new PostHistorySeason(season, null, episodes));
	}

	public void add(int season) {
		this.seasons.add(new PostHistorySeason(season));
	}

	@Override
	public Iterator<PostHistorySeason> iterator() {
		return seasons.iterator();
	}

	public final class PostHistorySeason {
		public int number;

		@SerializedName("watched_at")
		public Instant watchedAt;

		public PostHistoryEpisodes episodes;

		public PostHistorySeason(int number, Instant watchedAt, PostHistoryEpisodes episodes) {
			this.number = number;
			this.watchedAt = watchedAt;
			this.episodes = episodes;
		}

		public PostHistorySeason(int number, Instant watchedAt) {
			this(number, watchedAt, new PostHistoryEpisodes());
		}

		public PostHistorySeason(int number) {
			this(number, null);
		}

		public PostHistorySeason() {
			this(-1);
		}
	}
}
