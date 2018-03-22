package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowAlias;

public class TraktShowAliasImpl implements TraktShowAlias {
	private String title;
	//TODO Country enum
	private String country;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public TraktShowAlias withTitle(String title) {
		this.title = title;
		return this;
	}

	@Override
	public String getCountry() {
		return country;
	}

	@Override
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public TraktShowAlias withCountry(String country) {
		this.country = country;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktShowAliasImpl that = (TraktShowAliasImpl) o;

		return (title != null ? title.equals(that.title) : that.title == null) && (country != null ? country
				.equals(that.country) : that.country == null);
	}

	@Override
	public int hashCode() {
		int result = title != null ? title.hashCode() : 0;
		result = 31 * result + (country != null ? country.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktShowAlias{" + "title='" + title + '\'' + ", country='" + country + '\'' + '}';
	}
}
