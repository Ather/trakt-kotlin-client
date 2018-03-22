package media.thehoard.thirdparty.api.trakt.objects.get.shows;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl;

import java.util.List;

public interface TraktShowProgress<T extends TraktShowProgress<T>> {
	Integer getAired();

	void setAired(Integer aired);

	T withAired(Integer aired);

	Integer getCompleted();

	void setCompleted(Integer completed);

	T withCompleted(Integer completed);

	List<TraktSeasonImpl> getHiddenSeasons();

	void setHiddenSeasons(List<TraktSeasonImpl> hiddenSeasons);

	T withHiddenSeasons(List<TraktSeasonImpl> hiddenSeasons);

	TraktEpisode getNextEpisode();

	void setNextEpisode(TraktEpisodeImpl nextEpisode);

	T withNextEpisode(TraktEpisodeImpl nextEpisode);

	TraktEpisode getLastEpisode();

	void setLastEpisode(TraktEpisodeImpl lastEpisode);

	T withLastEpisode(TraktEpisodeImpl lastEpisode);
}
