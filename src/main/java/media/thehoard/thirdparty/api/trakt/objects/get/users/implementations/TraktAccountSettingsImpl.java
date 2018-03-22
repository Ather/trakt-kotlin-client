package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktAccountSettings;

public class TraktAccountSettingsImpl implements TraktAccountSettings {
	private String timezone;
	@SerializedName("time_24hr")
	private Boolean time24Hr;
	@SerializedName("cover_image")
	private String coverImage;

	@Override
	public String getTimezone() {
		return timezone;
	}

	@Override
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@Override
	public TraktAccountSettings withTimezone(String timezone) {
		this.timezone = timezone;
		return this;
	}

	@Override
	public Boolean getTime24Hr() {
		return time24Hr;
	}

	@Override
	public void setTime24Hr(Boolean time24Hr) {
		this.time24Hr = time24Hr;
	}

	@Override
	public TraktAccountSettings withTime24Hr(Boolean time24Hr) {
		this.time24Hr = time24Hr;
		return this;
	}

	@Override
	public String getCoverImage() {
		return coverImage;
	}

	@Override
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	@Override
	public TraktAccountSettings withCoverImage(String coverImage) {
		this.coverImage = coverImage;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktAccountSettingsImpl that = (TraktAccountSettingsImpl) o;

		if (timezone != null ? !timezone.equals(that.timezone) : that.timezone != null) return false;
		if (time24Hr != null ? !time24Hr.equals(that.time24Hr) : that.time24Hr != null) return false;
		return coverImage != null ? coverImage.equals(that.coverImage) : that.coverImage == null;
	}

	@Override
	public int hashCode() {
		int result = timezone != null ? timezone.hashCode() : 0;
		result = 31 * result + (time24Hr != null ? time24Hr.hashCode() : 0);
		result = 31 * result + (coverImage != null ? coverImage.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktAccountSettings{" + "timezone='" + timezone + '\'' + ", time24Hr=" + time24Hr + ", coverImage='" + coverImage + '\'' + '}';
	}
}
