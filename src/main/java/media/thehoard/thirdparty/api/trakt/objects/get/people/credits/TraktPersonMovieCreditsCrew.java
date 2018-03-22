package media.thehoard.thirdparty.api.trakt.objects.get.people.credits;

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonMovieCreditsCrewImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonMovieCreditsCrewItemImpl;

import java.util.List;

public interface TraktPersonMovieCreditsCrew {
	List<TraktPersonMovieCreditsCrewItemImpl> getProduction();

	void setProduction(List<TraktPersonMovieCreditsCrewItemImpl> production);

	TraktPersonMovieCreditsCrewImpl withProduction(List<TraktPersonMovieCreditsCrewItemImpl> production);

	List<TraktPersonMovieCreditsCrewItemImpl> getArt();

	void setArt(List<TraktPersonMovieCreditsCrewItemImpl> art);

	TraktPersonMovieCreditsCrewImpl withArt(List<TraktPersonMovieCreditsCrewItemImpl> art);

	List<TraktPersonMovieCreditsCrewItemImpl> getCrew();

	void setCrew(List<TraktPersonMovieCreditsCrewItemImpl> crew);

	TraktPersonMovieCreditsCrewImpl withCrew(List<TraktPersonMovieCreditsCrewItemImpl> crew);

	List<TraktPersonMovieCreditsCrewItemImpl> getCostumeAndMakeup();

	void setCostumeAndMakeup(List<TraktPersonMovieCreditsCrewItemImpl> costumeAndMakeup);

	TraktPersonMovieCreditsCrewImpl withCostumeAndMakeup(List<TraktPersonMovieCreditsCrewItemImpl> costumeAndMakeup);

	List<TraktPersonMovieCreditsCrewItemImpl> getDirecting();

	void setDirecting(List<TraktPersonMovieCreditsCrewItemImpl> directing);

	TraktPersonMovieCreditsCrewImpl withDirecting(List<TraktPersonMovieCreditsCrewItemImpl> directing);

	List<TraktPersonMovieCreditsCrewItemImpl> getWriting();

	void setWriting(List<TraktPersonMovieCreditsCrewItemImpl> writing);

	TraktPersonMovieCreditsCrewImpl withWriting(List<TraktPersonMovieCreditsCrewItemImpl> writing);

	List<TraktPersonMovieCreditsCrewItemImpl> getSound();

	void setSound(List<TraktPersonMovieCreditsCrewItemImpl> sound);

	TraktPersonMovieCreditsCrewImpl withSound(List<TraktPersonMovieCreditsCrewItemImpl> sound);

	List<TraktPersonMovieCreditsCrewItemImpl> getCamera();

	void setCamera(List<TraktPersonMovieCreditsCrewItemImpl> camera);

	TraktPersonMovieCreditsCrewImpl withCamera(List<TraktPersonMovieCreditsCrewItemImpl> camera);

	List<TraktPersonMovieCreditsCrewItemImpl> getLighting();

	void setLighting(List<TraktPersonMovieCreditsCrewItemImpl> lighting);

	TraktPersonMovieCreditsCrewImpl withLighting(List<TraktPersonMovieCreditsCrewItemImpl> lighting);

	List<TraktPersonMovieCreditsCrewItemImpl> getVisualEffects();

	void setVisualEffects(List<TraktPersonMovieCreditsCrewItemImpl> visualEffects);

	TraktPersonMovieCreditsCrewImpl withVisualEffects(List<TraktPersonMovieCreditsCrewItemImpl> visualEffects);

	List<TraktPersonMovieCreditsCrewItemImpl> getEditing();

	void setEditing(List<TraktPersonMovieCreditsCrewItemImpl> editing);

	TraktPersonMovieCreditsCrewImpl withEditing(List<TraktPersonMovieCreditsCrewItemImpl> editing);
}
