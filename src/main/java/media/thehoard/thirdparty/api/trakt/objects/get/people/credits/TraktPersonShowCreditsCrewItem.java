package media.thehoard.thirdparty.api.trakt.objects.get.people.credits;

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonShowCreditsCrewItemImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

public interface TraktPersonShowCreditsCrewItem {
	String getJob();

	void setJob(String job);

	TraktPersonShowCreditsCrewItemImpl withJob(String job);

	TraktShow getShow();

	void setShow(TraktShowImpl show);

	TraktPersonShowCreditsCrewItemImpl withShow(TraktShowImpl show);
}
