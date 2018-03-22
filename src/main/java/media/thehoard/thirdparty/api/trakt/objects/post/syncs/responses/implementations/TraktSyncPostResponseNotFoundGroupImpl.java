package media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.implementations;

import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.TraktPostResponseNotFoundEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.TraktPostResponseNotFoundMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.TraktPostResponseNotFoundSeasonImpl;
import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.TraktPostResponseNotFoundShowImpl;

import java.util.List;

public class TraktSyncPostResponseNotFoundGroupImpl {
	private List<TraktPostResponseNotFoundMovieImpl> movies;
	private List<TraktPostResponseNotFoundShowImpl> shows;
	private List<TraktPostResponseNotFoundSeasonImpl> seasons;
	private List<TraktPostResponseNotFoundEpisodeImpl> episodes;
}
