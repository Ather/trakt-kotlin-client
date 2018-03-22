package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

public interface TraktEpisodeCheckinPostResponse extends TraktCheckinPostResponse<TraktEpisodeCheckinPostResponse> {
	TraktEpisodeImpl getEpisode();

	void setEpisode(TraktEpisodeImpl episode);

	TraktEpisodeCheckinPostResponse withEpisode(TraktEpisodeImpl episode);

	TraktShowImpl getShow();

	void setShow(TraktShowImpl show);

	TraktEpisodeCheckinPostResponse withShow(TraktShowImpl show);
}
