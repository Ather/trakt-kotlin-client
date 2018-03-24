package media.thehoard.thirdparty.api.trakt.objects.get.people;

import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonExtendedImpl;

import java.time.Instant;
import java.util.Date;

public interface TraktPersonExtended extends TraktPerson<TraktPersonExtended> {
	String getBiography();

	void setBiography(String biography);

	TraktPersonExtendedImpl withBiography(String biography);

	Instant getBirthday();

	void setBirthday(Instant birthday);

	TraktPersonExtendedImpl withBirthday(Instant birthday);

	Instant getDeath();

	void setDeath(Instant death);

	TraktPersonExtendedImpl withDeath(Instant death);

	String getBirthplace();

	void setBirthplace(String birthplace);

	TraktPersonExtendedImpl withBirthplace(String birthplace);

	String getHomepage();

	void setHomepage(String homepage);

	TraktPersonExtendedImpl withHomepage(String homepage);

	int getAge();
}
