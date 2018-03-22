package media.thehoard.thirdparty.api.trakt.objects.post;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class PostRatingsSeasons implements Iterable<PostRatingsSeasons.PostRatingsSeason> {
	private final List<PostRatingsSeason> seasons;

	public PostRatingsSeasons() {
		this.seasons = new ArrayList<>();
	}

	public void add(int season, int rating, PostRatingsEpisodes episodes) {
		seasons.add(new PostRatingsSeason(season, rating, null, episodes));
	}

	public void add(int season, PostRatingsEpisodes episodes) {
		seasons.add(new PostRatingsSeason(season, null, null, episodes));
	}

	public void add(int season, int rating, Date ratedAt, PostRatingsEpisodes episodes) {
		seasons.add(new PostRatingsSeason(season, rating, ratedAt, episodes));
	}

	public void add(int season, int rating, Date ratedAt) {
		seasons.add(new PostRatingsSeason(season, rating, ratedAt));
	}

	public void add(int season, int rating) {
		seasons.add(new PostRatingsSeason(season, rating, null));
	}

	public void add(int season) {
		seasons.add(new PostRatingsSeason(season));
	}

	@Override
	public Iterator<PostRatingsSeason> iterator() {
		return seasons.iterator();
	}

	public final class PostRatingsSeason {
		public int number;

		public Integer rating;

		@SerializedName("rated_at")
		public Date ratedAt;

		public PostRatingsEpisodes episodes;

		public PostRatingsSeason(int number, Integer rating, Date ratedAt, PostRatingsEpisodes episodes) {
			this.number = number;
			this.rating = rating;
			this.ratedAt = ratedAt;
			this.episodes = episodes;
		}

		public PostRatingsSeason(int number, Integer rating, Date ratedAt) {
			this(number, rating, ratedAt, new PostRatingsEpisodes());
		}

		public PostRatingsSeason(int number, Integer rating) {
			this(number, rating, null);
		}

		public PostRatingsSeason(int number) {
			this(number, null);
		}

		public PostRatingsSeason() {
			this(-1);
		}
	}
}
