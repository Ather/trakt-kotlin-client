package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCredits;

import java.util.List;

public class TraktPersonShowCreditsImpl implements TraktPersonShowCredits {
	private List<TraktPersonShowCreditsCastItemImpl> cast;
	private TraktPersonShowCreditsCrewImpl crew;

	@Override
	public List<TraktPersonShowCreditsCastItemImpl> getCast() {
		return cast;
	}

	@Override
	public void setCast(List<TraktPersonShowCreditsCastItemImpl> cast) {
		this.cast = cast;
	}

	@Override
	public TraktPersonShowCreditsImpl withCast(List<TraktPersonShowCreditsCastItemImpl> cast) {
		this.cast = cast;
		return this;
	}

	@Override
	public TraktPersonShowCreditsCrewImpl getCrew() {
		return crew;
	}

	@Override
	public void setCrew(TraktPersonShowCreditsCrewImpl crew) {
		this.crew = crew;
	}

	@Override
	public TraktPersonShowCreditsImpl withCrew(TraktPersonShowCreditsCrewImpl crew) {
		this.crew = crew;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktPersonShowCreditsImpl that = (TraktPersonShowCreditsImpl) o;

		return (cast != null ? cast.equals(that.cast) : that.cast == null) && (crew != null ? crew.equals(that.crew)
				: that.crew == null);
	}

	@Override
	public int hashCode() {
		int result = cast != null ? cast.hashCode() : 0;
		result = 31 * result + (crew != null ? crew.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktPersonShowCreditsImpl{" + "cast=" + cast + ", crew=" + crew + '}';
	}
}
