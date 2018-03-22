package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations;

import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.*;

import java.util.List;

public class TraktUserCustomListItemsPostResponseNotFoundGroupImpl {
	public List<TraktPostResponseNotFoundMovieImpl> movies;

	public List<TraktPostResponseNotFoundShowImpl> shows;

	public List<TraktPostResponseNotFoundSeasonImpl> seasons;

	public List<TraktPostResponseNotFoundEpisodeImpl> episodes;

	public List<TraktPostResponseNotFoundPersonImpl> people;
}
