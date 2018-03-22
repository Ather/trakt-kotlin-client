package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktSharingText;

public class TraktSharingTextImpl implements TraktSharingText {
	private String watching;
	private String watched;

	@Override
	public String getWatching() {
		return watching;
	}

	@Override
	public void setWatching(String watching) {
		this.watching = watching;
	}

	@Override
	public TraktSharingText withWatching(String watching) {
		this.watching = watching;
		return this;
	}

	@Override
	public String getWatched() {
		return watched;
	}

	@Override
	public void setWatched(String watched) {
		this.watched = watched;
	}

	@Override
	public TraktSharingText withWatched(String watched) {
		this.watched = watched;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktSharingTextImpl that = (TraktSharingTextImpl) o;

		if (watching != null ? !watching.equals(that.watching) : that.watching != null) return false;
		return watched != null ? watched.equals(that.watched) : that.watched == null;
	}

	@Override
	public int hashCode() {
		int result = watching != null ? watching.hashCode() : 0;
		result = 31 * result + (watched != null ? watched.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktSharingText{" + "watching='" + watching + '\'' + ", watched='" + watched + '\'' + '}';
	}
}
