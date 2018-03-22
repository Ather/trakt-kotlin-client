package media.thehoard.thirdparty.api.trakt.objects.get.watched;

import media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations.TraktWatchedShowEpisodeImpl;

import java.util.List;

public interface TraktWatchedShowSeason {
	Integer getNumber();

	void setNumber(Integer number);

	TraktWatchedShowSeason withNumber(Integer number);

	List<TraktWatchedShowEpisodeImpl> getEpisodes();

	void setEpisodes(List<TraktWatchedShowEpisodeImpl> episodes);

	TraktWatchedShowSeason withEpisodes(List<TraktWatchedShowEpisodeImpl> episodes);
}
