package media.thehoard.thirdparty.api.trakt.objects.get.seasons;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeWatchedProgressImpl;

import java.util.List;

public interface TraktSeasonWatchedProgress extends TraktSeasonProgress<TraktSeasonWatchedProgress> {
	List<TraktEpisodeWatchedProgressImpl> getEpisodes();

	void setEpisodes(List<TraktEpisodeWatchedProgressImpl> episodes);

	TraktSeasonWatchedProgress withEpisodes(List<TraktEpisodeWatchedProgressImpl> episodes);
}
