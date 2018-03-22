package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCreditsCrew;

import java.util.List;

public class TraktPersonShowCreditsCrewImpl implements TraktPersonShowCreditsCrew {
	private List<TraktPersonShowCreditsCrewItemImpl> production;
	private List<TraktPersonShowCreditsCrewItemImpl> art;
	private List<TraktPersonShowCreditsCrewItemImpl> crew;
	@SerializedName("costume & make-up")
	private List<TraktPersonShowCreditsCrewItemImpl> costumeAndMakeup;
	private List<TraktPersonShowCreditsCrewItemImpl> directing;
	private List<TraktPersonShowCreditsCrewItemImpl> writing;
	private List<TraktPersonShowCreditsCrewItemImpl> sound;
	private List<TraktPersonShowCreditsCrewItemImpl> camera;
	private List<TraktPersonShowCreditsCrewItemImpl> lighting;
	@SerializedName("visual effects")
	private List<TraktPersonShowCreditsCrewItemImpl> visualEffects;
	private List<TraktPersonShowCreditsCrewItemImpl> editing;

	@Override
	public List<TraktPersonShowCreditsCrewItemImpl> getProduction() {
		return production;
	}

	@Override
	public void setProduction(List<TraktPersonShowCreditsCrewItemImpl> production) {
		this.production = production;
	}

	@Override
	public TraktPersonShowCreditsCrewImpl withProduction(List<TraktPersonShowCreditsCrewItemImpl> production) {
		this.production = production;
		return this;
	}

	@Override
	public List<TraktPersonShowCreditsCrewItemImpl> getArt() {
		return art;
	}

	@Override
	public void setArt(List<TraktPersonShowCreditsCrewItemImpl> art) {
		this.art = art;
	}

	@Override
	public TraktPersonShowCreditsCrewImpl withArt(List<TraktPersonShowCreditsCrewItemImpl> art) {
		this.art = art;
		return this;
	}

	@Override
	public List<TraktPersonShowCreditsCrewItemImpl> getCrew() {
		return crew;
	}

	@Override
	public void setCrew(List<TraktPersonShowCreditsCrewItemImpl> crew) {
		this.crew = crew;
	}

	@Override
	public TraktPersonShowCreditsCrewImpl withCrew(List<TraktPersonShowCreditsCrewItemImpl> crew) {
		this.crew = crew;
		return this;
	}

	@Override
	public List<TraktPersonShowCreditsCrewItemImpl> getCostumeAndMakeup() {
		return costumeAndMakeup;
	}

	@Override
	public void setCostumeAndMakeup(List<TraktPersonShowCreditsCrewItemImpl> costumeAndMakeup) {
		this.costumeAndMakeup = costumeAndMakeup;
	}

	@Override
	public TraktPersonShowCreditsCrewImpl withCostumeAndMakeup(List<TraktPersonShowCreditsCrewItemImpl> costumeAndMakeup) {
		this.costumeAndMakeup = costumeAndMakeup;
		return this;
	}

	@Override
	public List<TraktPersonShowCreditsCrewItemImpl> getDirecting() {
		return directing;
	}

	@Override
	public void setDirecting(List<TraktPersonShowCreditsCrewItemImpl> directing) {
		this.directing = directing;
	}

	@Override
	public TraktPersonShowCreditsCrewImpl withDirecting(List<TraktPersonShowCreditsCrewItemImpl> directing) {
		this.directing = directing;
		return this;
	}

	@Override
	public List<TraktPersonShowCreditsCrewItemImpl> getWriting() {
		return writing;
	}

	@Override
	public void setWriting(List<TraktPersonShowCreditsCrewItemImpl> writing) {
		this.writing = writing;
	}

	@Override
	public TraktPersonShowCreditsCrewImpl withWriting(List<TraktPersonShowCreditsCrewItemImpl> writing) {
		this.writing = writing;
		return this;
	}

	@Override
	public List<TraktPersonShowCreditsCrewItemImpl> getSound() {
		return sound;
	}

	@Override
	public void setSound(List<TraktPersonShowCreditsCrewItemImpl> sound) {
		this.sound = sound;
	}

	@Override
	public TraktPersonShowCreditsCrewImpl withSound(List<TraktPersonShowCreditsCrewItemImpl> sound) {
		this.sound = sound;
		return this;
	}

	@Override
	public List<TraktPersonShowCreditsCrewItemImpl> getCamera() {
		return camera;
	}

	@Override
	public void setCamera(List<TraktPersonShowCreditsCrewItemImpl> camera) {
		this.camera = camera;
	}

	@Override
	public TraktPersonShowCreditsCrewImpl withCamera(List<TraktPersonShowCreditsCrewItemImpl> camera) {
		this.camera = camera;
		return this;
	}

	@Override
	public List<TraktPersonShowCreditsCrewItemImpl> getLighting() {
		return lighting;
	}

	@Override
	public void setLighting(List<TraktPersonShowCreditsCrewItemImpl> lighting) {
		this.lighting = lighting;
	}

	@Override
	public TraktPersonShowCreditsCrewImpl withLighting(List<TraktPersonShowCreditsCrewItemImpl> lighting) {
		this.lighting = lighting;
		return this;
	}

	@Override
	public List<TraktPersonShowCreditsCrewItemImpl> getVisualEffects() {
		return visualEffects;
	}

	@Override
	public void setVisualEffects(List<TraktPersonShowCreditsCrewItemImpl> visualEffects) {
		this.visualEffects = visualEffects;
	}

	@Override
	public TraktPersonShowCreditsCrewImpl withVisualEffects(List<TraktPersonShowCreditsCrewItemImpl> visualEffects) {
		this.visualEffects = visualEffects;
		return this;
	}

	@Override
	public List<TraktPersonShowCreditsCrewItemImpl> getEditing() {
		return editing;
	}

	@Override
	public void setEditing(List<TraktPersonShowCreditsCrewItemImpl> editing) {
		this.editing = editing;
	}

	@Override
	public TraktPersonShowCreditsCrewImpl withEditing(List<TraktPersonShowCreditsCrewItemImpl> editing) {
		this.editing = editing;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktPersonShowCreditsCrewImpl that = (TraktPersonShowCreditsCrewImpl) o;

		return (production != null ? production.equals(that.production) : that.production == null) && (art != null ? art
				.equals(that.art) : that.art == null) && (crew != null ? crew.equals(that.crew)
				: that.crew == null) && (costumeAndMakeup != null ? costumeAndMakeup.equals(that.costumeAndMakeup)
				: that.costumeAndMakeup == null) && (directing != null ? directing.equals(that.directing)
				: that.directing == null) && (writing != null ? writing.equals(that.writing)
				: that.writing == null) && (sound != null ? sound.equals(that.sound) : that.sound == null) && (
				camera != null ? camera.equals(that.camera) : that.camera == null) && (lighting != null ? lighting
				.equals(that.lighting) : that.lighting == null) && (visualEffects != null ? visualEffects
				.equals(that.visualEffects) : that.visualEffects == null) && (editing != null ? editing
				.equals(that.editing) : that.editing == null);
	}

	@Override
	public int hashCode() {
		int result = production != null ? production.hashCode() : 0;
		result = 31 * result + (art != null ? art.hashCode() : 0);
		result = 31 * result + (crew != null ? crew.hashCode() : 0);
		result = 31 * result + (costumeAndMakeup != null ? costumeAndMakeup.hashCode() : 0);
		result = 31 * result + (directing != null ? directing.hashCode() : 0);
		result = 31 * result + (writing != null ? writing.hashCode() : 0);
		result = 31 * result + (sound != null ? sound.hashCode() : 0);
		result = 31 * result + (camera != null ? camera.hashCode() : 0);
		result = 31 * result + (lighting != null ? lighting.hashCode() : 0);
		result = 31 * result + (visualEffects != null ? visualEffects.hashCode() : 0);
		result = 31 * result + (editing != null ? editing.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktPersonShowCreditsCrewImpl{" + "production=" + production + ", art=" + art + ", crew=" + crew + ", costumeAndMakeup=" + costumeAndMakeup + ", directing=" + directing + ", writing=" + writing + ", sound=" + sound + ", camera=" + camera + ", lighting=" + lighting + ", visualEffects=" + visualEffects + ", editing=" + editing + '}';
	}
}
