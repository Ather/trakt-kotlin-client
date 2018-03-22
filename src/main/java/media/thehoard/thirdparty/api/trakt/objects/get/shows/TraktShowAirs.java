package media.thehoard.thirdparty.api.trakt.objects.get.shows;

public interface TraktShowAirs {
	String getDay();

	void setDay(String day);

	TraktShowAirs withDay(String day);

	String getTime();

	void setTime(String time);

	TraktShowAirs withTime(String time);

	String getTimezone();

	void setTimezone(String timezone);

	TraktShowAirs withTimezone(String timezone);
}
