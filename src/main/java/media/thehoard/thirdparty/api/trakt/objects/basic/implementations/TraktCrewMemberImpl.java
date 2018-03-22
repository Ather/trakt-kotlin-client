package media.thehoard.thirdparty.api.trakt.objects.basic.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCrewMember;
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl;

public class TraktCrewMemberImpl implements TraktCrewMember {
	private String job;
	private TraktPersonImpl person;

	@Override
	public String getJob() {
		return job;
	}

	@Override
	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public TraktPersonImpl getPerson() {
		return person;
	}

	@Override
	public void setPerson(TraktPersonImpl person) {
		this.person = person;
	}
}
