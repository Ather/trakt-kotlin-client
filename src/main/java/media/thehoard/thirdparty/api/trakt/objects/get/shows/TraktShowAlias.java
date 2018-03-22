package media.thehoard.thirdparty.api.trakt.objects.get.shows;

public interface TraktShowAlias {
	String getTitle();

	void setTitle(String title);

	TraktShowAlias withTitle(String title);

	String getCountry();

	void setCountry(String country);

	TraktShowAlias withCountry(String country);
}
