package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCreditsCastItem;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

public class TraktPersonShowCreditsCastItemImpl implements TraktPersonShowCreditsCastItem {
	private String character;
	private TraktShowImpl show;

	@Override
	public String getCharacter() {
		return character;
	}

	@Override
	public void setCharacter(String character) {
		this.character = character;
	}

	@Override
	public TraktPersonShowCreditsCastItemImpl withCharacter(String character) {
		this.character = character;
		return this;
	}

	@Override
	public TraktShow getShow() {
		return show;
	}

	@Override
	public void setShow(TraktShowImpl show) {
		this.show = show;
	}

	@Override
	public TraktPersonShowCreditsCastItemImpl withShow(TraktShowImpl show) {
		this.show = show;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktPersonShowCreditsCastItemImpl that = (TraktPersonShowCreditsCastItemImpl) o;

		return (character != null ? character.equals(that.character) : that.character == null) && (show != null ? show
				.equals(that.show) : that.show == null);
	}

	@Override
	public int hashCode() {
		int result = character != null ? character.hashCode() : 0;
		result = 31 * result + (show != null ? show.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktPersonShowCreditsCastItemImpl{" + "character='" + character + '\'' + ", show=" + show + '}';
	}
}
