package media.thehoard.thirdparty.api.trakt.objects.basic.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktGenre;

public class TraktGenreImpl implements TraktGenre {
	private String name;
	private String slug;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getSlug() {
		return slug;

	}

	@Override
	public void setSlug(String slug) {
		this.slug = slug;
	}
}
