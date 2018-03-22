package media.thehoard.thirdparty.api.trakt.objects.get.people;

import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonExtendedImpl;

import java.util.Date;

public interface TraktPersonExtended extends TraktPerson<TraktPersonExtended> {
	String getBiography();

	void setBiography(String biography);

	TraktPersonExtendedImpl withBiography(String biography);

	Date getBirthday();

	void setBirthday(Date birthday);

	TraktPersonExtendedImpl withBirthday(Date birthday);

	Date getDeath();

	void setDeath(Date death);

	TraktPersonExtendedImpl withDeath(Date death);

	String getBirthplace();

	void setBirthplace(String birthplace);

	TraktPersonExtendedImpl withBirthplace(String birthplace);

	String getHomepage();

	void setHomepage(String homepage);

	TraktPersonExtendedImpl withHomepage(String homepage);

	int getAge();
}
