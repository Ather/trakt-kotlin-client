package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImagesImpl;

import java.time.Instant;

public interface TraktUserExtended extends TraktUser<TraktUserExtended> {
	Instant getJoinedAt();

	void setJoinedAt(Instant joinedAt);

	TraktUserExtended withJoinedAt(Instant joinedAt);

	String getLocation();

	void setLocation(String location);

	TraktUserExtended withLocation(String location);

	String getAbout();

	void setAbout(String about);

	TraktUserExtended withAbout(String about);

	String getGender();

	void setGender(String gender);

	TraktUserExtended withGender(String gender);

	Integer getAge();

	void setAge(Integer age);

	TraktUserExtended withAge(Integer age);

	TraktUserImages getImages();

	void setImages(TraktUserImagesImpl images);

	TraktUserExtended withImages(TraktUserImagesImpl images);

	Boolean getVipOg();

	void setVipOg(Boolean vipOg);

	TraktUserExtended withVipOg(Boolean vipOg);

	Integer getVipYears();

	void setVipYears(Integer vipYears);

	TraktUserExtended withVipYears(Integer vipYears);
}
