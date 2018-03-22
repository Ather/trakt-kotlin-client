package media.thehoard.thirdparty.api.trakt.objects.get.seasons;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeCollectionProgress;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeCollectionProgressImpl;

import java.util.List;

public interface TraktSeasonCollectionProgress extends TraktSeasonProgress<TraktSeasonCollectionProgress> {
	List<TraktEpisodeCollectionProgressImpl> getEpisodes();

	void setEpisodes(List<TraktEpisodeCollectionProgressImpl> episodes);

	TraktSeasonCollectionProgress withEpisodes(List<TraktEpisodeCollectionProgressImpl> episodes);
}
