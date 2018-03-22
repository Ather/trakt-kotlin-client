package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieTranslation;

public class TraktMovieTranslationImpl implements TraktMovieTranslation {
	private String title;
	private String overview;
	private String language;

	private String tagline;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public TraktMovieTranslationImpl withTitle(String title) {
		this.title = title;
		return this;
	}

	@Override
	public String getOverview() {

		return overview;
	}

	@Override
	public void setOverview(String overview) {
		this.overview = overview;
	}

	@Override
	public TraktMovieTranslationImpl withOverview(String overview) {
		this.overview = overview;
		return this;
	}

	@Override
	public String getLanguage() {
		return language;
	}

	@Override
	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public TraktMovieTranslationImpl withLanguage(String language) {
		this.language = language;
		return this;
	}

	@Override
	public String getTagline() {
		return tagline;
	}

	@Override
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	@Override
	public TraktMovieTranslation withTagline(String tagline) {
		this.tagline = tagline;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktMovieTranslationImpl that = (TraktMovieTranslationImpl) o;

		return tagline != null ? tagline.equals(that.tagline) : that.tagline == null;
	}

	@Override
	public int hashCode() {
		return tagline != null ? tagline.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "TraktMovieTranslation{" + "tagline='" + tagline + '\'' + '}';
	}
}
