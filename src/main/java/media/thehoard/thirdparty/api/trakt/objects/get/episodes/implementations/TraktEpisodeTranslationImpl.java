package media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeTranslation;

public class TraktEpisodeTranslationImpl implements TraktEpisodeTranslation {
	private String title;
	private String overview;
	private String language;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public TraktEpisodeTranslation withTitle(String title) {
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
	public TraktEpisodeTranslation withOverview(String overview) {
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
	public TraktEpisodeTranslation withLanguage(String language) {
		this.language = language;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktEpisodeTranslationImpl that = (TraktEpisodeTranslationImpl) o;

		return (title != null ? title.equals(that.title) : that.title == null) && (overview != null ? overview
				.equals(that.overview) : that.overview == null) && (language != null ? language.equals(that.language)
				: that.language == null);
	}

	@Override
	public int hashCode() {
		int result = title != null ? title.hashCode() : 0;
		result = 31 * result + (overview != null ? overview.hashCode() : 0);
		result = 31 * result + (language != null ? language.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktEpisodeTranslation{" + "title='" + title + '\'' + ", overview='" + overview + '\'' + ", language='" + language + '\'' + '}';
	}
}
