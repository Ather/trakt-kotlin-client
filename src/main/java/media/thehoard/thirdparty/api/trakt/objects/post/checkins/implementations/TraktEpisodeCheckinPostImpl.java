package media.thehoard.thirdparty.api.trakt.objects.post.checkins.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.TraktEpisodeCheckinPost;

public class TraktEpisodeCheckinPostImpl implements TraktEpisodeCheckinPost {
	private TraktSharingImpl sharing;
	private String message;
	@SerializedName("app_version")
	private String appVersion;
	@SerializedName("app_date")
	private String appDate;
	@SerializedName("venue_id")
	private String foursquareVenueId;
	@SerializedName("venue_name")
	private String foursquareVenueName;

	private TraktEpisodeImpl episode;
	private TraktShowImpl show;

	@Override
	public TraktSharingImpl getSharing() {
		return sharing;
	}

	@Override
	public void setSharing(TraktSharingImpl sharing) {
		this.sharing = sharing;
	}

	@Override
	public TraktEpisodeCheckinPost withSharing(TraktSharingImpl sharing) {
		this.sharing = sharing;
		return this;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public TraktEpisodeCheckinPost withMessage(String message) {
		this.message = message;
		return this;
	}

	@Override
	public String getAppVersion() {
		return appVersion;
	}

	@Override
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	@Override
	public TraktEpisodeCheckinPost withAppVersion(String appVersion) {
		this.appVersion = appVersion;
		return this;
	}

	@Override
	public String getAppDate() {
		return appDate;
	}

	@Override
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	@Override
	public TraktEpisodeCheckinPost withAppDate(String appDate) {
		this.appDate = appDate;
		return this;
	}

	@Override
	public String getFoursquareVenueId() {
		return foursquareVenueId;
	}

	@Override
	public void setFoursquareVenueId(String foursquareVenueId) {
		this.foursquareVenueId = foursquareVenueId;
	}

	@Override
	public TraktEpisodeCheckinPost withFoursquareVenueId(String foursquareVenueId) {
		this.foursquareVenueId = foursquareVenueId;
		return this;
	}

	@Override
	public String getFoursquareVenueName() {
		return foursquareVenueName;
	}

	@Override
	public void setFoursquareVenueName(String foursquareVenueName) {
		this.foursquareVenueName = foursquareVenueName;
	}

	@Override
	public TraktEpisodeCheckinPost withFoursquareVenueName(String foursquareVenueName) {
		this.foursquareVenueName = foursquareVenueName;
		return this;
	}

	@Override
	public TraktEpisodeImpl getEpisode() {
		return episode;
	}

	@Override
	public void setEpisode(TraktEpisodeImpl episode) {
		this.episode = episode;
	}

	@Override
	public TraktEpisodeCheckinPost withEpisode(TraktEpisodeImpl episode) {
		this.episode = episode;
		return this;
	}

	@Override
	public TraktShowImpl getShow() {
		return show;
	}

	@Override
	public void setShow(TraktShowImpl show) {
		this.show = show;
	}

	@Override
	public TraktEpisodeCheckinPost withShow(TraktShowImpl show) {
		this.show = show;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		TraktEpisodeCheckinPostImpl that = (TraktEpisodeCheckinPostImpl) o;

		if (episode != null ? !episode.equals(that.episode) : that.episode != null) return false;
		return show != null ? show.equals(that.show) : that.show == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (episode != null ? episode.hashCode() : 0);
		result = 31 * result + (show != null ? show.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktEpisodeCheckinPost{" + "episode=" + episode + ", show=" + show + '}';
	}
}
