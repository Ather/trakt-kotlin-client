package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCredits;

import java.util.List;

public class TraktPersonMovieCreditsImpl implements TraktPersonMovieCredits {
	private List<TraktPersonMovieCreditsCastItemImpl> cast;
	private TraktPersonMovieCreditsCrewImpl crew;

	@Override
	public List<TraktPersonMovieCreditsCastItemImpl> getCast() {
		return cast;
	}

	@Override
	public void setCast(List<TraktPersonMovieCreditsCastItemImpl> cast) {
		this.cast = cast;
	}

	@Override
	public TraktPersonMovieCreditsImpl withCast(List<TraktPersonMovieCreditsCastItemImpl> cast) {
		this.cast = cast;
		return this;
	}

	@Override
	public TraktPersonMovieCreditsCrewImpl getCrew() {
		return crew;
	}

	@Override
	public void setCrew(TraktPersonMovieCreditsCrewImpl crew) {
		this.crew = crew;
	}

	@Override
	public TraktPersonMovieCreditsImpl withCrew(TraktPersonMovieCreditsCrewImpl crew) {
		this.crew = crew;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktPersonMovieCreditsImpl that = (TraktPersonMovieCreditsImpl) o;

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
		return "TraktPersonMovieCreditsImpl{" + "cast=" + cast + ", crew=" + crew + '}';
	}
}
