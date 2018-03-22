package media.thehoard.thirdparty.api.trakt.objects.basic;

import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPerson;
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl;

public interface TraktCastMember {
	String getCharacter();

	void setCharacter(String character);

	TraktPerson getPerson();

	void setPerson(TraktPersonImpl person);
}
