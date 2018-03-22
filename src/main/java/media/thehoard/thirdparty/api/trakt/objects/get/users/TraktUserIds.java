package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds;

public interface TraktUserIds extends TraktDefaultIds {
	String getSlug();

	void setSlug(String slug);

	TraktUserIds withSlug(String slug);
}
