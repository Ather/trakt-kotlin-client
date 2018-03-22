package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserIdsImpl;

public interface TraktUser<T extends TraktUser<T>> {
	String getUsername();

	void setUsername(String username);

	T withUsername(String username);

	Boolean getPrivate();

	void setPrivate(Boolean aPrivate);

	T withPrivate(Boolean aPrivate);

	String getName();

	void setName(String name);

	T withName(String name);

	Boolean getVip();

	void setVip(Boolean vip);

	T withVip(Boolean vip);

	Boolean getVipEp();

	void setVipEp(Boolean vipEp);

	T withVipEp(Boolean vipEp);

	TraktUserIds getIds();

	void setIds(TraktUserIdsImpl ids);

	T withIds(TraktUserIdsImpl ids);
}
