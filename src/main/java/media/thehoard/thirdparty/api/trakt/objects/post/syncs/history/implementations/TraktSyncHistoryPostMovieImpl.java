package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl;

import java.util.Date;

public class TraktSyncHistoryPostMovieImpl {
	@SerializedName("watched_at")
	private Date watchedAt;
	private String title;
	private Integer year;
	private TraktMovieIdsImpl ids;
}
