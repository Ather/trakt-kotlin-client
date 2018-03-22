package media.thehoard.thirdparty.api.trakt.objects.basic.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCastMember;
import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPerson;
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl;

public class TraktCastMemberImpl implements TraktCastMember {
	private String character;
	private TraktPersonImpl person;

	@Override
	public String getCharacter() {
		return character;
	}

	@Override
	public void setCharacter(String character) {
		this.character = character;
	}

	@Override
	public TraktPerson getPerson() {
		return person;
	}

	@Override
	public void setPerson(TraktPersonImpl person) {
		this.person = person;
	}
}
