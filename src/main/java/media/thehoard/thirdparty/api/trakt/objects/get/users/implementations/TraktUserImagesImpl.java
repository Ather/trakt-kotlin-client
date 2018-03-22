package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktImageImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserImages;

public class TraktUserImagesImpl implements TraktUserImages {
	private TraktImageImpl avatar;

	@Override
	public TraktImageImpl getAvatar() {
		return avatar;
	}

	@Override
	public void setAvatar(TraktImageImpl avatar) {
		this.avatar = avatar;
	}

	@Override
	public TraktUserImages withAvatar(TraktImageImpl avatar) {
		this.avatar = avatar;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserImagesImpl that = (TraktUserImagesImpl) o;

		return avatar != null ? avatar.equals(that.avatar) : that.avatar == null;
	}

	@Override
	public int hashCode() {
		return avatar != null ? avatar.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "TraktUserImages{" + "avatar=" + avatar + '}';
	}
}
