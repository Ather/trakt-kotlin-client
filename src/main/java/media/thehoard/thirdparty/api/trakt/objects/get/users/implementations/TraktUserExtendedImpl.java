package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserExtended;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserIds;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserImages;

import java.time.Instant;

public class TraktUserExtendedImpl implements TraktUserExtended {
	private String username;
	@SerializedName("private")
	private Boolean isPrivate;
	private String name;
	@SerializedName("vip")
	private Boolean isVip;
	@SerializedName("vip_ep")
	private Boolean isVipEp;
	private TraktUserIdsImpl ids;

	@SerializedName("joined_at")
	private Instant joinedAt;
	private String location;
	private String about;
	private String gender;
	private Integer age;
	private TraktUserImagesImpl images;
	@SerializedName("vip_og")
	private Boolean isVipOg;
	@SerializedName("vip_years")
	private Integer vipYears;

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public TraktUserExtended withUsername(String username) {
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
	public TraktUserExtended withPrivate(Boolean aPrivate) {
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
	public TraktUserExtended withName(String name) {
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
	public TraktUserExtended withVip(Boolean vip) {
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
	public TraktUserExtended withVipEp(Boolean vipEp) {
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
	public TraktUserExtended withIds(TraktUserIdsImpl ids) {
		this.ids = ids;
		return this;
	}

	@Override
	public Instant getJoinedAt() {
		return joinedAt;
	}

	@Override
	public void setJoinedAt(Instant joinedAt) {
		this.joinedAt = joinedAt;
	}

	@Override
	public TraktUserExtended withJoinedAt(Instant joinedAt) {
		this.joinedAt = joinedAt;
		return this;
	}

	@Override
	public String getLocation() {
		return location;
	}

	@Override
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public TraktUserExtended withLocation(String location) {
		this.location = location;
		return this;
	}

	@Override
	public String getAbout() {
		return about;
	}

	@Override
	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public TraktUserExtended withAbout(String about) {
		this.about = about;
		return this;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public TraktUserExtended withGender(String gender) {
		this.gender = gender;
		return this;
	}

	@Override
	public Integer getAge() {
		return age;
	}

	@Override
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public TraktUserExtended withAge(Integer age) {
		this.age = age;
		return this;
	}

	@Override
	public TraktUserImages getImages() {
		return images;
	}

	@Override
	public void setImages(TraktUserImagesImpl images) {
		this.images = images;
	}

	@Override
	public TraktUserExtended withImages(TraktUserImagesImpl images) {
		this.images = images;
		return this;
	}

	@Override
	public Boolean getVipOg() {
		return isVipOg;
	}

	@Override
	public void setVipOg(Boolean vipOg) {
		isVipOg = vipOg;
	}

	@Override
	public TraktUserExtended withVipOg(Boolean vipOg) {
		isVipOg = vipOg;
		return this;
	}

	@Override
	public Integer getVipYears() {
		return vipYears;
	}

	@Override
	public void setVipYears(Integer vipYears) {
		this.vipYears = vipYears;
	}

	@Override
	public TraktUserExtended withVipYears(Integer vipYears) {
		this.vipYears = vipYears;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserExtendedImpl that = (TraktUserExtendedImpl) o;

		if (username != null ? !username.equals(that.username) : that.username != null) return false;
		if (isPrivate != null ? !isPrivate.equals(that.isPrivate) : that.isPrivate != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (isVip != null ? !isVip.equals(that.isVip) : that.isVip != null) return false;
		if (isVipEp != null ? !isVipEp.equals(that.isVipEp) : that.isVipEp != null) return false;
		if (ids != null ? !ids.equals(that.ids) : that.ids != null) return false;
		if (joinedAt != null ? !joinedAt.equals(that.joinedAt) : that.joinedAt != null) return false;
		if (location != null ? !location.equals(that.location) : that.location != null) return false;
		if (about != null ? !about.equals(that.about) : that.about != null) return false;
		if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
		if (age != null ? !age.equals(that.age) : that.age != null) return false;
		if (images != null ? !images.equals(that.images) : that.images != null) return false;
		if (isVipOg != null ? !isVipOg.equals(that.isVipOg) : that.isVipOg != null) return false;
		return vipYears != null ? vipYears.equals(that.vipYears) : that.vipYears == null;
	}

	@Override
	public int hashCode() {
		int result = username != null ? username.hashCode() : 0;
		result = 31 * result + (isPrivate != null ? isPrivate.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (isVip != null ? isVip.hashCode() : 0);
		result = 31 * result + (isVipEp != null ? isVipEp.hashCode() : 0);
		result = 31 * result + (ids != null ? ids.hashCode() : 0);
		result = 31 * result + (joinedAt != null ? joinedAt.hashCode() : 0);
		result = 31 * result + (location != null ? location.hashCode() : 0);
		result = 31 * result + (about != null ? about.hashCode() : 0);
		result = 31 * result + (gender != null ? gender.hashCode() : 0);
		result = 31 * result + (age != null ? age.hashCode() : 0);
		result = 31 * result + (images != null ? images.hashCode() : 0);
		result = 31 * result + (isVipOg != null ? isVipOg.hashCode() : 0);
		result = 31 * result + (vipYears != null ? vipYears.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktUserExtended{" + "username='" + username + '\'' + ", isPrivate=" + isPrivate + ", name='" + name + '\'' + ", isVip=" + isVip + ", isVipEp=" + isVipEp + ", ids=" + ids + ", joinedAt=" + joinedAt + ", location='" + location + '\'' + ", about='" + about + '\'' + ", gender='" + gender + '\'' + ", age=" + age + ", images=" + images + ", isVipOg=" + isVipOg + ", vipYears=" + vipYears + '}';
	}
}
