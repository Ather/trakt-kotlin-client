package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserIds;
import media.thehoard.thirdparty.api.trakt.utils.TraktUtils;

public class TraktUserIdsImpl implements TraktUserIds {
	private String slug;

	@Override
	public String getSlug() {
		return slug;
	}

	@Override
	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Override
	public TraktUserIds withSlug(String slug) {
		this.slug = slug;
		return this;
	}

	@Override
	public boolean hasAnyId() {
		return !TraktUtils.isNullOrEmpty(slug);
	}

	@Override
	public String getBestId() {
		if (!TraktUtils.isNullOrEmpty(slug)) return slug;

		return "";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserIdsImpl that = (TraktUserIdsImpl) o;

		return slug != null ? slug.equals(that.slug) : that.slug == null;
	}

	@Override
	public int hashCode() {
		return slug != null ? slug.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "TraktUserIds{" + "slug='" + slug + '\'' + '}';
	}
}
