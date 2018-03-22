package media.thehoard.thirdparty.api.trakt.objects.basic;

import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl;

public interface TraktCrewMember {
	String getJob();

	void setJob(String job);

	TraktPersonImpl getPerson();

	void setPerson(TraktPersonImpl person);
}
