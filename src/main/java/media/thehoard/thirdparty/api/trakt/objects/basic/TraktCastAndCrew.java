package media.thehoard.thirdparty.api.trakt.objects.basic;

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCastMemberImpl;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCrewImpl;

import java.util.List;

public interface TraktCastAndCrew {
	List<TraktCastMemberImpl> getCast();

	void setCast(List<TraktCastMemberImpl> cast);

	TraktCrew getCrew();

	void setCrew(TraktCrewImpl crew);
}
