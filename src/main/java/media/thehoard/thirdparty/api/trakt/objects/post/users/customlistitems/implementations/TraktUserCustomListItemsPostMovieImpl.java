package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl;

public class TraktUserCustomListItemsPostMovieImpl {
	private TraktMovieIdsImpl ids;

	public TraktUserCustomListItemsPostMovieImpl() {}

	public TraktUserCustomListItemsPostMovieImpl(TraktMovieIds ids) {
		this.ids = ids;
	}
}
