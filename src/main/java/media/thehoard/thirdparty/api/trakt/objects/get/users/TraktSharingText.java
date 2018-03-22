package media.thehoard.thirdparty.api.trakt.objects.get.users;

public interface TraktSharingText {
	String getWatching();

	void setWatching(String watching);

	TraktSharingText withWatching(String watching);

	String getWatched();

	void setWatched(String watched);

	TraktSharingText withWatched(String watched);
}
