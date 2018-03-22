package media.thehoard.thirdparty.api.trakt.objects.get.users;

public interface TraktAccountSettings {
	String getTimezone();

	void setTimezone(String timezone);

	TraktAccountSettings withTimezone(String timezone);

	Boolean getTime24Hr();

	void setTime24Hr(Boolean time24Hr);

	TraktAccountSettings withTime24Hr(Boolean time24Hr);

	String getCoverImage();

	void setCoverImage(String coverImage);

	TraktAccountSettings withCoverImage(String coverImage);
}
