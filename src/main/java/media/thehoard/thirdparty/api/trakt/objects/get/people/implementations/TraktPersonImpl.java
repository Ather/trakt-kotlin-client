package media.thehoard.thirdparty.api.trakt.objects.get.people.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPerson;

public class TraktPersonImpl implements TraktPerson {
	private String name;
	private TraktPersonIdsImpl ids;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public TraktPersonImpl withName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public TraktPersonIdsImpl getIds() {
		return ids;
	}

	@Override
	public void setIds(TraktPersonIdsImpl ids) {
		this.ids = ids;
	}

	@Override
	public TraktPersonImpl withIds(TraktPersonIdsImpl ids) {
		this.ids = ids;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktPersonImpl that = (TraktPersonImpl) o;

		return (name != null ? name.equals(that.name) : that.name == null) && (ids != null ? ids.equals(that.ids)
				: that.ids == null);
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (ids != null ? ids.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktPersonImpl{" + "name='" + name + '\'' + ", ids=" + ids + '}';
	}
}
