package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowAirs;

public class TraktShowAirsImpl implements TraktShowAirs {
	private String day;
	private String time;
	private String timezone;

	@Override
	public String getDay() {
		return day;
	}

	@Override
	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public TraktShowAirs withDay(String day) {
		this.day = day;
		return this;
	}

	@Override
	public String getTime() {
		return time;
	}

	@Override
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public TraktShowAirs withTime(String time) {
		this.time = time;
		return this;
	}

	@Override
	public String getTimezone() {
		return timezone;
	}

	@Override
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@Override
	public TraktShowAirs withTimezone(String timezone) {
		this.timezone = timezone;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktShowAirsImpl that = (TraktShowAirsImpl) o;

		return (day != null ? day.equals(that.day) : that.day == null) && (time != null ? time.equals(that.time)
				: that.time == null) && (timezone != null ? timezone.equals(that.timezone) : that.timezone == null);
	}

	@Override
	public int hashCode() {
		int result = day != null ? day.hashCode() : 0;
		result = 31 * result + (time != null ? time.hashCode() : 0);
		result = 31 * result + (timezone != null ? timezone.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktShowAirs{" + "day='" + day + '\'' + ", time='" + time + '\'' + ", timezone='" + timezone + '\'' + '}';
	}
}
