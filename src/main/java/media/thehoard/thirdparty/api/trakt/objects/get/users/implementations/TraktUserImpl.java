package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserIds;

public class TraktUserImpl implements TraktUser {
	private String username;
	@SerializedName("private")
	private Boolean isPrivate;
	private String name;
	@SerializedName("vip")
	private Boolean isVip;
	@SerializedName("vip_ep")
	private Boolean isVipEp;
	private TraktUserIdsImpl ids;

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public TraktUser withUsername(String username) {
		this.username = username;
		return this;
	}

	@Override
	public Boolean getPrivate() {
		return isPrivate;
	}

	@Override
	public void setPrivate(Boolean aPrivate) {
		isPrivate = aPrivate;
	}

	@Override
	public TraktUser withPrivate(Boolean aPrivate) {
		isPrivate = aPrivate;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public TraktUser withName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public Boolean getVip() {
		return isVip;
	}

	@Override
	public void setVip(Boolean vip) {
		isVip = vip;
	}

	@Override
	public TraktUser withVip(Boolean vip) {
		isVip = vip;
		return this;
	}

	@Override
	public Boolean getVipEp() {
		return isVipEp;
	}

	@Override
	public void setVipEp(Boolean vipEp) {
		isVipEp = vipEp;
	}

	@Override
	public TraktUser withVipEp(Boolean vipEp) {
		isVipEp = vipEp;
		return this;
	}

	@Override
	public TraktUserIds getIds() {
		return ids;
	}

	@Override
	public void setIds(TraktUserIdsImpl ids) {
		this.ids = ids;
	}

	@Override
	public TraktUser withIds(TraktUserIdsImpl ids) {
		this.ids = ids;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserImpl traktUser = (TraktUserImpl) o;

		if (username != null ? !username.equals(traktUser.username) : traktUser.username != null) return false;
		if (isPrivate != null ? !isPrivate.equals(traktUser.isPrivate) : traktUser.isPrivate != null) return false;
		if (name != null ? !name.equals(traktUser.name) : traktUser.name != null) return false;
		if (isVip != null ? !isVip.equals(traktUser.isVip) : traktUser.isVip != null) return false;
		if (isVipEp != null ? !isVipEp.equals(traktUser.isVipEp) : traktUser.isVipEp != null) return false;
		return ids != null ? ids.equals(traktUser.ids) : traktUser.ids == null;
	}

	@Override
	public int hashCode() {
		int result = username != null ? username.hashCode() : 0;
		result = 31 * result + (isPrivate != null ? isPrivate.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (isVip != null ? isVip.hashCode() : 0);
		result = 31 * result + (isVipEp != null ? isVipEp.hashCode() : 0);
		result = 31 * result + (ids != null ? ids.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktUser{" + "username='" + username + '\'' + ", isPrivate=" + isPrivate + ", name='" + name + '\'' + ", isVip=" + isVip + ", isVipEp=" + isVipEp + ", ids=" + ids + '}';
	}
}
