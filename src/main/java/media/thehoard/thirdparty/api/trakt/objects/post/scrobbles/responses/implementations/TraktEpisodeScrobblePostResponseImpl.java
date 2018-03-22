package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

public class TraktEpisodeScrobblePostResponseImpl extends AbstractTraktScrobblePostResponse {
	private TraktEpisodeImpl episode;
	private TraktShowImpl show;
}
