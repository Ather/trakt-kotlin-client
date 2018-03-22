package media.thehoard.thirdparty.api.trakt.objects.get.people.credits;

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonShowCreditsCrewImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonShowCreditsCrewItemImpl;

import java.util.List;

public interface TraktPersonShowCreditsCrew {
	List<TraktPersonShowCreditsCrewItemImpl> getProduction();

	void setProduction(List<TraktPersonShowCreditsCrewItemImpl> production);

	TraktPersonShowCreditsCrewImpl withProduction(List<TraktPersonShowCreditsCrewItemImpl> production);

	List<TraktPersonShowCreditsCrewItemImpl> getArt();

	void setArt(List<TraktPersonShowCreditsCrewItemImpl> art);

	TraktPersonShowCreditsCrewImpl withArt(List<TraktPersonShowCreditsCrewItemImpl> art);

	List<TraktPersonShowCreditsCrewItemImpl> getCrew();

	void setCrew(List<TraktPersonShowCreditsCrewItemImpl> crew);

	TraktPersonShowCreditsCrewImpl withCrew(List<TraktPersonShowCreditsCrewItemImpl> crew);

	List<TraktPersonShowCreditsCrewItemImpl> getCostumeAndMakeup();

	void setCostumeAndMakeup(List<TraktPersonShowCreditsCrewItemImpl> costumeAndMakeup);

	TraktPersonShowCreditsCrewImpl withCostumeAndMakeup(List<TraktPersonShowCreditsCrewItemImpl> costumeAndMakeup);

	List<TraktPersonShowCreditsCrewItemImpl> getDirecting();

	void setDirecting(List<TraktPersonShowCreditsCrewItemImpl> directing);

	TraktPersonShowCreditsCrewImpl withDirecting(List<TraktPersonShowCreditsCrewItemImpl> directing);

	List<TraktPersonShowCreditsCrewItemImpl> getWriting();

	void setWriting(List<TraktPersonShowCreditsCrewItemImpl> writing);

	TraktPersonShowCreditsCrewImpl withWriting(List<TraktPersonShowCreditsCrewItemImpl> writing);

	List<TraktPersonShowCreditsCrewItemImpl> getSound();

	void setSound(List<TraktPersonShowCreditsCrewItemImpl> sound);

	TraktPersonShowCreditsCrewImpl withSound(List<TraktPersonShowCreditsCrewItemImpl> sound);

	List<TraktPersonShowCreditsCrewItemImpl> getCamera();

	void setCamera(List<TraktPersonShowCreditsCrewItemImpl> camera);

	TraktPersonShowCreditsCrewImpl withCamera(List<TraktPersonShowCreditsCrewItemImpl> camera);

	List<TraktPersonShowCreditsCrewItemImpl> getLighting();

	void setLighting(List<TraktPersonShowCreditsCrewItemImpl> lighting);

	TraktPersonShowCreditsCrewImpl withLighting(List<TraktPersonShowCreditsCrewItemImpl> lighting);

	List<TraktPersonShowCreditsCrewItemImpl> getVisualEffects();

	void setVisualEffects(List<TraktPersonShowCreditsCrewItemImpl> visualEffects);

	TraktPersonShowCreditsCrewImpl withVisualEffects(List<TraktPersonShowCreditsCrewItemImpl> visualEffects);

	List<TraktPersonShowCreditsCrewItemImpl> getEditing();

	void setEditing(List<TraktPersonShowCreditsCrewItemImpl> editing);

	TraktPersonShowCreditsCrewImpl withEditing(List<TraktPersonShowCreditsCrewItemImpl> editing);
}
