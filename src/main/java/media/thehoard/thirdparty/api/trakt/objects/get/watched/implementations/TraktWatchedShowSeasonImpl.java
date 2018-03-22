package media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedShowSeason;

import java.util.List;

public class TraktWatchedShowSeasonImpl implements TraktWatchedShowSeason {
	private Integer number;
	private List<TraktWatchedShowEpisodeImpl> episodes;

	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public TraktWatchedShowSeason withNumber(Integer number) {
		this.number = number;
		return this;
	}

	@Override
	public List<TraktWatchedShowEpisodeImpl> getEpisodes() {
		return episodes;
	}

	@Override
	public void setEpisodes(List<TraktWatchedShowEpisodeImpl> episodes) {
		this.episodes = episodes;
	}

	@Override
	public TraktWatchedShowSeason withEpisodes(List<TraktWatchedShowEpisodeImpl> episodes) {
		this.episodes = episodes;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktWatchedShowSeasonImpl that = (TraktWatchedShowSeasonImpl) o;

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
		return "TraktWatchedShowSeason{" + "number=" + number + ", episodes=" + episodes + '}';
	}
}
