package media.thehoard.thirdparty.api.trakt.objects.get.people.credits;

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonShowCreditsCastItemImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonShowCreditsCrewImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonShowCreditsImpl;

import java.util.List;

public interface TraktPersonShowCredits {
	List<TraktPersonShowCreditsCastItemImpl> getCast();

	void setCast(List<TraktPersonShowCreditsCastItemImpl> cast);

	TraktPersonShowCreditsImpl withCast(List<TraktPersonShowCreditsCastItemImpl> cast);

	TraktPersonShowCreditsCrewImpl getCrew();

	void setCrew(TraktPersonShowCreditsCrewImpl crew);

	TraktPersonShowCreditsImpl withCrew(TraktPersonShowCreditsCrewImpl crew);
}
