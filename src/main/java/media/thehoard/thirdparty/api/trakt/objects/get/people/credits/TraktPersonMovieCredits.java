package media.thehoard.thirdparty.api.trakt.objects.get.people.credits;

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonMovieCreditsCastItemImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonMovieCreditsCrewImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonMovieCreditsImpl;

import java.util.List;

public interface TraktPersonMovieCredits {
	List<TraktPersonMovieCreditsCastItemImpl> getCast();

	void setCast(List<TraktPersonMovieCreditsCastItemImpl> cast);

	TraktPersonMovieCreditsImpl withCast(List<TraktPersonMovieCreditsCastItemImpl> cast);

	TraktPersonMovieCreditsCrewImpl getCrew();

	void setCrew(TraktPersonMovieCreditsCrewImpl crew);

	TraktPersonMovieCreditsImpl withCrew(TraktPersonMovieCreditsCrewImpl crew);
}
