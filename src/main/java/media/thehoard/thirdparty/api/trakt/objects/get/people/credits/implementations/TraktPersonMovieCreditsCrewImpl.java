package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCreditsCrew;

import java.util.List;

public class TraktPersonMovieCreditsCrewImpl implements TraktPersonMovieCreditsCrew {
	private List<TraktPersonMovieCreditsCrewItemImpl> production;
	private List<TraktPersonMovieCreditsCrewItemImpl> art;
	private List<TraktPersonMovieCreditsCrewItemImpl> crew;
	@SerializedName("costume & make-up")
	private List<TraktPersonMovieCreditsCrewItemImpl> costumeAndMakeup;
	private List<TraktPersonMovieCreditsCrewItemImpl> directing;
	private List<TraktPersonMovieCreditsCrewItemImpl> writing;
	private List<TraktPersonMovieCreditsCrewItemImpl> sound;
	private List<TraktPersonMovieCreditsCrewItemImpl> camera;
	private List<TraktPersonMovieCreditsCrewItemImpl> lighting;
	@SerializedName("visual effects")
	private List<TraktPersonMovieCreditsCrewItemImpl> visualEffects;
	private List<TraktPersonMovieCreditsCrewItemImpl> editing;

	@Override
	public List<TraktPersonMovieCreditsCrewItemImpl> getProduction() {
		return production;
	}

	@Override
	public void setProduction(List<TraktPersonMovieCreditsCrewItemImpl> production) {
		this.production = production;
	}

	@Override
	public TraktPersonMovieCreditsCrewImpl withProduction(List<TraktPersonMovieCreditsCrewItemImpl> production) {
		this.production = production;
		return this;
	}

	@Override
	public List<TraktPersonMovieCreditsCrewItemImpl> getArt() {
		return art;
	}

	@Override
	public void setArt(List<TraktPersonMovieCreditsCrewItemImpl> art) {
		this.art = art;
	}

	@Override
	public TraktPersonMovieCreditsCrewImpl withArt(List<TraktPersonMovieCreditsCrewItemImpl> art) {
		this.art = art;
		return this;
	}

	@Override
	public List<TraktPersonMovieCreditsCrewItemImpl> getCrew() {
		return crew;
	}

	@Override
	public void setCrew(List<TraktPersonMovieCreditsCrewItemImpl> crew) {
		this.crew = crew;
	}

	@Override
	public TraktPersonMovieCreditsCrewImpl withCrew(List<TraktPersonMovieCreditsCrewItemImpl> crew) {
		this.crew = crew;
		return this;
	}

	@Override
	public List<TraktPersonMovieCreditsCrewItemImpl> getCostumeAndMakeup() {
		return costumeAndMakeup;
	}

	@Override
	public void setCostumeAndMakeup(List<TraktPersonMovieCreditsCrewItemImpl> costumeAndMakeup) {
		this.costumeAndMakeup = costumeAndMakeup;
	}

	@Override
	public TraktPersonMovieCreditsCrewImpl withCostumeAndMakeup(List<TraktPersonMovieCreditsCrewItemImpl> costumeAndMakeup) {
		this.costumeAndMakeup = costumeAndMakeup;
		return this;
	}

	@Override
	public List<TraktPersonMovieCreditsCrewItemImpl> getDirecting() {
		return directing;
	}

	@Override
	public void setDirecting(List<TraktPersonMovieCreditsCrewItemImpl> directing) {
		this.directing = directing;
	}

	@Override
	public TraktPersonMovieCreditsCrewImpl withDirecting(List<TraktPersonMovieCreditsCrewItemImpl> directing) {
		this.directing = directing;
		return this;
	}

	@Override
	public List<TraktPersonMovieCreditsCrewItemImpl> getWriting() {
		return writing;
	}

	@Override
	public void setWriting(List<TraktPersonMovieCreditsCrewItemImpl> writing) {
		this.writing = writing;
	}

	@Override
	public TraktPersonMovieCreditsCrewImpl withWriting(List<TraktPersonMovieCreditsCrewItemImpl> writing) {
		this.writing = writing;
		return this;
	}

	@Override
	public List<TraktPersonMovieCreditsCrewItemImpl> getSound() {
		return sound;
	}

	@Override
	public void setSound(List<TraktPersonMovieCreditsCrewItemImpl> sound) {
		this.sound = sound;
	}

	@Override
	public TraktPersonMovieCreditsCrewImpl withSound(List<TraktPersonMovieCreditsCrewItemImpl> sound) {
		this.sound = sound;
		return this;
	}

	@Override
	public List<TraktPersonMovieCreditsCrewItemImpl> getCamera() {
		return camera;
	}

	@Override
	public void setCamera(List<TraktPersonMovieCreditsCrewItemImpl> camera) {
		this.camera = camera;
	}

	@Override
	public TraktPersonMovieCreditsCrewImpl withCamera(List<TraktPersonMovieCreditsCrewItemImpl> camera) {
		this.camera = camera;
		return this;
	}

	@Override
	public List<TraktPersonMovieCreditsCrewItemImpl> getLighting() {
		return lighting;
	}

	@Override
	public void setLighting(List<TraktPersonMovieCreditsCrewItemImpl> lighting) {
		this.lighting = lighting;
	}

	@Override
	public TraktPersonMovieCreditsCrewImpl withLighting(List<TraktPersonMovieCreditsCrewItemImpl> lighting) {
		this.lighting = lighting;
		return this;
	}

	@Override
	public List<TraktPersonMovieCreditsCrewItemImpl> getVisualEffects() {
		return visualEffects;
	}

	@Override
	public void setVisualEffects(List<TraktPersonMovieCreditsCrewItemImpl> visualEffects) {
		this.visualEffects = visualEffects;
	}

	@Override
	public TraktPersonMovieCreditsCrewImpl withVisualEffects(List<TraktPersonMovieCreditsCrewItemImpl> visualEffects) {
		this.visualEffects = visualEffects;
		return this;
	}

	@Override
	public List<TraktPersonMovieCreditsCrewItemImpl> getEditing() {
		return editing;
	}

	@Override
	public void setEditing(List<TraktPersonMovieCreditsCrewItemImpl> editing) {
		this.editing = editing;
	}

	@Override
	public TraktPersonMovieCreditsCrewImpl withEditing(List<TraktPersonMovieCreditsCrewItemImpl> editing) {
		this.editing = editing;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktPersonMovieCreditsCrewImpl that = (TraktPersonMovieCreditsCrewImpl) o;

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
		return "TraktPersonMovieCreditsCrewImpl{" + "production=" + production + ", art=" + art + ", crew=" + crew + ", costumeAndMakeup=" + costumeAndMakeup + ", directing=" + directing + ", writing=" + writing + ", sound=" + sound + ", camera=" + camera + ", lighting=" + lighting + ", visualEffects=" + visualEffects + ", editing=" + editing + '}';
	}
}
