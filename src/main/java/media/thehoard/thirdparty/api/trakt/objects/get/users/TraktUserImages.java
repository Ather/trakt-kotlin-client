package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktImageImpl;

public interface TraktUserImages {
	TraktImageImpl getAvatar();

	void setAvatar(TraktImageImpl avatar);

	TraktUserImages withAvatar(TraktImageImpl avatar);
}
