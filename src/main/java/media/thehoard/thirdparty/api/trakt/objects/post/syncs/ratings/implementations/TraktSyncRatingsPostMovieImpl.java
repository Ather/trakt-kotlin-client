package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl;

import java.util.Date;

public class TraktSyncRatingsPostMovieImpl {
	@SerializedName("rated_at")
	private Date ratedAt;
	private Integer rating;
	private String title;
	private Integer year;
	private TraktMovieIdsImpl ids;
}
