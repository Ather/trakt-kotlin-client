package media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations;


import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeCollectionProgressImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonCollectionProgress;

import java.util.List;

public class TraktSeasonCollectionProgressImpl implements TraktSeasonCollectionProgress {
	private Integer number;
	private Integer aired;
	private Integer completed;

	private List<TraktEpisodeCollectionProgressImpl> episodes;

	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public TraktSeasonCollectionProgress withNumber(Integer number) {
		this.number = number;
		return this;
	}

	@Override
	public Integer getAired() {
		return aired;
	}

	@Override
	public void setAired(Integer aired) {
		this.aired = aired;
	}

	@Override
	public TraktSeasonCollectionProgress withAired(Integer aired) {
		this.aired = aired;
		return this;
	}

	@Override
	public Integer getCompleted() {
		return completed;
	}

	@Override
	public void setCompleted(Integer completed) {
		this.completed = completed;
	}

	@Override
	public TraktSeasonCollectionProgress withCompleted(Integer completed) {
		this.completed = completed;
		return this;
	}

	@Override
	public List<TraktEpisodeCollectionProgressImpl> getEpisodes() {
		return episodes;
	}

	@Override
	public void setEpisodes(List<TraktEpisodeCollectionProgressImpl> episodes) {
		this.episodes = episodes;
	}

	@Override
	public TraktSeasonCollectionProgress withEpisodes(List<TraktEpisodeCollectionProgressImpl> episodes) {
		this.episodes = episodes;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktSeasonCollectionProgressImpl that = (TraktSeasonCollectionProgressImpl) o;

		return (number != null ? number.equals(that.number) : that.number == null) && (aired != null ? aired
				.equals(that.aired) : that.aired == null) && (completed != null ? completed.equals(that.completed)
				: that.completed == null) && (episodes != null ? episodes.equals(that.episodes)
				: that.episodes == null);
	}

	@Override
	public int hashCode() {
		int result = number != null ? number.hashCode() : 0;
		result = 31 * result + (aired != null ? aired.hashCode() : 0);
		result = 31 * result + (completed != null ? completed.hashCode() : 0);
		result = 31 * result + (episodes != null ? episodes.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktSeasonCollectionProgress{" + "number=" + number + ", aired=" + aired + ", completed=" + completed + ", episodes=" + episodes + '}';
	}
}
