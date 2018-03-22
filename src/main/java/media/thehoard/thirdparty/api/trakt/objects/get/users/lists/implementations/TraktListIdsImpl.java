package media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktListIds;
import media.thehoard.thirdparty.api.trakt.utils.TraktUtils;

public class TraktListIdsImpl implements TraktListIds {
	private int trakt;
	private String slug;

	@Override
	public boolean hasAnyId() {
		return trakt > 0 || !TraktUtils.isNullOrEmpty(slug);
	}

	@Override
	public String getBestId() {
		if (trakt > 0) return String.valueOf(trakt);

		if (!TraktUtils.isNullOrEmpty(slug)) return slug;

		return "";
	}

	@Override
	public int getTrakt() {
		return trakt;
	}

	@Override
	public void setTrakt(int trakt) {
		this.trakt = trakt;
	}

	@Override
	public TraktListIds withTrakt(int trakt) {
		this.trakt = trakt;
		return this;
	}

	@Override
	public String getSlug() {
		return slug;
	}

	@Override
	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Override
	public TraktListIds withSlug(String slug) {
		this.slug = slug;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktListIdsImpl that = (TraktListIdsImpl) o;

		if (trakt != that.trakt) return false;
		return slug != null ? slug.equals(that.slug) : that.slug == null;
	}

	@Override
	public int hashCode() {
		int result = trakt;
		result = 31 * result + (slug != null ? slug.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktListIds{" + "trakt=" + trakt + ", slug='" + slug + '\'' + '}';
	}
}
