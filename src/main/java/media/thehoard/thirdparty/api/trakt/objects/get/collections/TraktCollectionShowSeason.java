package media.thehoard.thirdparty.api.trakt.objects.get.collections;

import media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionShowEpisodeImpl;

import java.util.List;

public interface TraktCollectionShowSeason {
	Integer getNumber();

	void setNumber(Integer number);

	TraktCollectionShowSeason withNumber(Integer number);

	List<TraktCollectionShowEpisodeImpl> getEpisodes();

	void setEpisodes(List<TraktCollectionShowEpisodeImpl> episodes);

	TraktCollectionShowSeason withEpisodes(List<TraktCollectionShowEpisodeImpl> episodes);
}
