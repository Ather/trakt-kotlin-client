package media.thehoard.thirdparty.api.trakt.objects.basic.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCastAndCrew;
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCrew;

import java.util.List;

public class TraktCastAndCrewImpl implements TraktCastAndCrew {
	private List<TraktCastMemberImpl> cast;
	private TraktCrewImpl crew;

	@Override
	public List<TraktCastMemberImpl> getCast() {
		return cast;
	}

	@Override
	public void setCast(List<TraktCastMemberImpl> cast) {
		this.cast = cast;
	}

	@Override
	public TraktCrew getCrew() {
		return crew;
	}

	@Override
	public void setCrew(TraktCrewImpl crew) {
		this.crew = crew;
	}
}
