package media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.TraktCalendarEpisode;
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.TraktCalendarShow;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.util.Date;

public class TraktCalendarShowImpl implements TraktCalendarShow {
	@SerializedName("first_aired")
	private Date firstAired;
	private TraktEpisodeImpl episode;
	private TraktShowImpl show;

	@Override
	public Date getFirstAired() {
		return firstAired;
	}

	@Override
	public void setFirstAired(Date firstAired) {
		this.firstAired = firstAired;
	}

	@Override
	public TraktCalendarShow withFirstAired(Date firstAired) {
		this.firstAired = firstAired;
		return this;
	}

	@Override
	public TraktEpisode getEpisode() {
		return episode;
	}

	@Override
	public void setEpisode(TraktEpisodeImpl episode) {
		this.episode = episode;
	}

	@Override
	public TraktCalendarShow withEpisode(TraktEpisodeImpl episode) {
		this.episode = episode;
		return this;
	}

	@Override
	public TraktShow getShow() {
		return show;
	}

	@Override
	public void setShow(TraktShowImpl show) {
		this.show = show;
	}

	@Override
	public TraktCalendarShow withShow(TraktShowImpl show) {
		this.show = show;
		return this;
	}

	@Override
	public String getTitle() {
		return show != null ? show.getTitle() : null;
	}

	@Override
	public void setTitle(String title) {
		if (show != null) show.setTitle(title);
	}

	@Override
	public TraktCalendarShow withTitle(String title) {
		if (show != null) show.setTitle(title);
		return this;
	}

	@Override
	public Integer getYear() {
		return show != null ? show.getYear() : null;
	}

	@Override
	public void setYear(Integer year) {
		if (show != null) show.setYear(year);
	}

	@Override
	public TraktCalendarShow withYear(Integer year) {
		if (show != null) show.setYear(year);
		return this;
	}

	@Override
	public TraktShowIdsImpl getIds() {
		return show != null ? show.getIds() : null;
	}

	@Override
	public void setIds(TraktShowIdsImpl ids) {
		if (show != null) show.setIds(ids);
	}

	@Override
	public TraktCalendarShow withIds(TraktShowIdsImpl ids) {
		if (show != null) show.setIds(ids);
		return this;
	}

	@Override
	public Integer getSeason() {
		return episode != null ? episode.getSeason() : null;
	}

	@Override
	public void setSeason(Integer season) {
		if (episode != null)
			episode.setSeason(season);
	}

	@Override
	public TraktCalendarShow withSeason(Integer season) {
		if (episode != null)
			episode.setSeason(season);
		return this;
	}

	@Override
	public Integer getEpisodeNumber() {
		return episode != null ? episode.getNumber() : null;
	}

	@Override
	public void setEpisodeNumber(Integer number) {
		if (episode != null)
			episode.setNumber(number);
	}

	@Override
	public TraktCalendarShow withEpisodeNumber(Integer number) {
		if (episode != null)
			episode.setNumber(number);
		return this;
	}

	@Override
	public String getEpisodeTitle() {
		return episode != null ? episode.getTitle() : null;
	}

	@Override
	public void setEpisodeTitle(String title) {
		if (episode != null)
			episode.setTitle(title);
	}

	@Override
	public TraktCalendarShow withEpisodeTitle(String title) {
		if (episode != null)
			episode.setTitle(title);
		return this;
	}

	@Override
	public TraktEpisodeIds getEpisodeIds() {
		return episode != null ? episode.getIds() : null;
	}

	@Override
	public void setEpisodeIds(TraktEpisodeIds ids) {
		if (episode != null)
			episode.setIds(ids);
	}

	@Override
	public TraktCalendarShow withEpisodeIds(TraktEpisodeIds ids) {
		if (episode != null)
			episode.setIds(ids);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktCalendarShowImpl that = (TraktCalendarShowImpl) o;

		return (firstAired != null ? firstAired.equals(that.firstAired) : that.firstAired == null) && (episode != null
				? episode.equals(that.episode) : that.episode == null) && (show != null ? show.equals(that.show)
				: that.show == null);
	}

	@Override
	public int hashCode() {
		int result = firstAired != null ? firstAired.hashCode() : 0;
		result = 31 * result + (episode != null ? episode.hashCode() : 0);
		result = 31 * result + (show != null ? show.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktCalendarShow{" + "firstAired=" + firstAired + ", episode=" + episode + ", show=" + show + '}';
	}
}
