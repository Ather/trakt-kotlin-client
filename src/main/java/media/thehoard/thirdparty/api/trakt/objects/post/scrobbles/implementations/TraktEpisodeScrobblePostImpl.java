package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

public class TraktEpisodeScrobblePostImpl extends AbstractTraktScrobblePost {
	private TraktEpisodeImpl episode;
	private TraktShowImpl show;
}
