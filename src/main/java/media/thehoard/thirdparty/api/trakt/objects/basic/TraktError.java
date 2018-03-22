package media.thehoard.thirdparty.api.trakt.objects.basic;

public interface TraktError {
	String getError();

	void setError(String error);

	String getDescription();

	void setDescription(String description);
}
