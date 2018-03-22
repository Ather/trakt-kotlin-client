package media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds;

public class TraktEpisodeImpl implements TraktEpisode {
	private Integer season;
	private Integer number;
	private String title;
	private TraktEpisodeIdsImpl ids;

	@Override
	public Integer getSeason() {
		return season;
	}

	@Override
	public void setSeason(Integer season) {
		this.season = season;
	}

	@Override
	public TraktEpisode withSeason(Integer season) {
		this.season = season;
		return this;
	}

	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public TraktEpisode withNumber(Integer number) {
		this.number = number;
		return this;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public TraktEpisode withTitle(String title) {
		this.title = title;
		return this;
	}

	@Override
	public TraktEpisodeIds getIds() {
		return ids;
	}

	@Override
	public void setIds(TraktEpisodeIdsImpl ids) {
		this.ids = ids;
	}

	@Override
	public TraktEpisode withIds(TraktEpisodeIdsImpl ids) {
		this.ids = ids;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktEpisodeImpl that = (TraktEpisodeImpl) o;

		return (season != null ? season.equals(that.season) : that.season == null) && (number != null ? number
				.equals(that.number) : that.number == null) && (title != null ? title.equals(that.title)
				: that.title == null) && (ids != null ? ids.equals(that.ids) : that.ids == null);
	}

	@Override
	public int hashCode() {
		int result = season != null ? season.hashCode() : 0;
		result = 31 * result + (number != null ? number.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (ids != null ? ids.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktEpisode{" + "season=" + season + ", number=" + number + ", title='" + title + '\'' + ", ids=" + ids + '}';
	}
}
