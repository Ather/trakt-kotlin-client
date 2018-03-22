package media.thehoard.thirdparty.api.trakt.objects.basic;

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCrewMemberImpl;

import java.util.List;

public interface TraktCrew {
	List<TraktCrewMemberImpl> getProduction();

	void setProduction(List<TraktCrewMemberImpl> production);

	List<TraktCrewMemberImpl> getArt();

	void setArt(List<TraktCrewMemberImpl> art);

	List<TraktCrewMemberImpl> getCrew();

	void setCrew(List<TraktCrewMemberImpl> crew);

	List<TraktCrewMemberImpl> getCostumeAndMakeup();

	void setCostumeAndMakeup(List<TraktCrewMemberImpl> costumeAndMakeup);

	List<TraktCrewMemberImpl> getDirecting();

	void setDirecting(List<TraktCrewMemberImpl> directing);

	List<TraktCrewMemberImpl> getWriting();

	void setWriting(List<TraktCrewMemberImpl> writing);

	List<TraktCrewMemberImpl> getSound();

	void setSound(List<TraktCrewMemberImpl> sound);

	List<TraktCrewMemberImpl> getCamera();

	void setCamera(List<TraktCrewMemberImpl> camera);

	List<TraktCrewMemberImpl> getLighting();

	void setLighting(List<TraktCrewMemberImpl> lighting);

	List<TraktCrewMemberImpl> getVisualEffects();

	void setVisualEffects(List<TraktCrewMemberImpl> visualEffects);

	List<TraktCrewMemberImpl> getEditing();

	void setEditing(List<TraktCrewMemberImpl> editing);
}
