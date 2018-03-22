package media.thehoard.thirdparty.api.trakt.objects.basic.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCrew;
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCrewMember;

import java.util.List;

public class TraktCrewImpl implements TraktCrew {
	private List<TraktCrewMemberImpl> production;
	private List<TraktCrewMemberImpl> art;
	private List<TraktCrewMemberImpl> crew;
	@SerializedName("costume & make-up")
	private List<TraktCrewMemberImpl> costumeAndMakeup;
	private List<TraktCrewMemberImpl> directing;
	private List<TraktCrewMemberImpl> writing;
	private List<TraktCrewMemberImpl> sound;
	private List<TraktCrewMemberImpl> camera;
	private List<TraktCrewMemberImpl> lighting;
	@SerializedName("visual effects")
	private List<TraktCrewMemberImpl> visualEffects;
	private List<TraktCrewMemberImpl> editing;

	@Override
	public List<TraktCrewMemberImpl> getProduction() {
		return production;
	}

	@Override
	public void setProduction(List<TraktCrewMemberImpl> production) {
		this.production = production;
	}

	@Override
	public List<TraktCrewMemberImpl> getArt() {
		return art;
	}

	@Override
	public void setArt(List<TraktCrewMemberImpl> art) {
		this.art = art;
	}

	@Override
	public List<TraktCrewMemberImpl> getCrew() {
		return crew;
	}

	@Override
	public void setCrew(List<TraktCrewMemberImpl> crew) {
		this.crew = crew;
	}

	@Override
	public List<TraktCrewMemberImpl> getCostumeAndMakeup() {
		return costumeAndMakeup;
	}

	@Override
	public void setCostumeAndMakeup(List<TraktCrewMemberImpl> costumeAndMakeup) {
		this.costumeAndMakeup = costumeAndMakeup;
	}

	@Override
	public List<TraktCrewMemberImpl> getDirecting() {
		return directing;
	}

	@Override
	public void setDirecting(List<TraktCrewMemberImpl> directing) {
		this.directing = directing;
	}

	@Override
	public List<TraktCrewMemberImpl> getWriting() {
		return writing;
	}

	@Override
	public void setWriting(List<TraktCrewMemberImpl> writing) {
		this.writing = writing;
	}

	@Override
	public List<TraktCrewMemberImpl> getSound() {
		return sound;
	}

	@Override
	public void setSound(List<TraktCrewMemberImpl> sound) {
		this.sound = sound;
	}

	@Override
	public List<TraktCrewMemberImpl> getCamera() {
		return camera;
	}

	@Override
	public void setCamera(List<TraktCrewMemberImpl> camera) {
		this.camera = camera;
	}

	@Override
	public List<TraktCrewMemberImpl> getLighting() {
		return lighting;
	}

	@Override
	public void setLighting(List<TraktCrewMemberImpl> lighting) {
		this.lighting = lighting;
	}

	@Override
	public List<TraktCrewMemberImpl> getVisualEffects() {
		return visualEffects;
	}

	@Override
	public void setVisualEffects(List<TraktCrewMemberImpl> visualEffects) {
		this.visualEffects = visualEffects;
	}

	@Override
	public List<TraktCrewMemberImpl> getEditing() {
		return editing;
	}

	@Override
	public void setEditing(List<TraktCrewMemberImpl> editing) {
		this.editing = editing;
	}
}
