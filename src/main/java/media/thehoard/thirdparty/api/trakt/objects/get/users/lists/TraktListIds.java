package media.thehoard.thirdparty.api.trakt.objects.get.users.lists;

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds;

public interface TraktListIds extends
		TraktDefaultIds {
	int getTrakt();

	void setTrakt(int trakt);

	TraktListIds withTrakt(int trakt);

	String getSlug();

	void setSlug(String slug);

	TraktListIds withSlug(String slug);
}
