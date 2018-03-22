package media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowSeason;

import java.util.List;

public class TraktCollectionShowSeasonImpl
		implements media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowSeason {
	private Integer number;
	private List<TraktCollectionShowEpisodeImpl> episodes;

	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public TraktCollectionShowSeason withNumber(Integer number) {
		this.number = number;
		return this;
	}

	@Override
	public List<TraktCollectionShowEpisodeImpl> getEpisodes() {
		return episodes;
	}

	@Override
	public void setEpisodes(List<TraktCollectionShowEpisodeImpl> episodes) {
		this.episodes = episodes;
	}

	@Override
	public TraktCollectionShowSeason withEpisodes(List<TraktCollectionShowEpisodeImpl> episodes) {
		this.episodes = episodes;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktCollectionShowSeasonImpl that = (TraktCollectionShowSeasonImpl) o;

		if (number != null ? !number.equals(that.number) : that.number != null) return false;
		return episodes != null ? episodes.equals(that.episodes) : that.episodes == null;
	}

	@Override
	public int hashCode() {
		int result = number != null ? number.hashCode() : 0;
		result = 31 * result + (episodes != null ? episodes.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktCollectionShowSeason{" + "number=" + number + ", episodes=" + episodes + '}';
	}
}
