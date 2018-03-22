package media.thehoard.thirdparty.api.trakt.objects.get.people.credits;

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonShowCreditsCastItemImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

public interface TraktPersonShowCreditsCastItem {
	String getCharacter();

	void setCharacter(String character);

	TraktPersonShowCreditsCastItemImpl withCharacter(String character);

	TraktShow getShow();

	void setShow(TraktShowImpl show);

	TraktPersonShowCreditsCastItemImpl withShow(TraktShowImpl show);
}
