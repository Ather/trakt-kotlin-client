package media.thehoard.thirdparty.api.trakt.objects.basic;

import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser;

import java.util.Date;

public interface TraktComment {
	int getId();

	void setId(int id);

	Integer getParentId();

	void setParentId(Integer parentId);

	Date getCreatedAt();

	void setCreatedAt(Date createdAt);

	Date getUpdatedAt();

	void setUpdatedAt(Date updatedAt);

	String getComment();

	void setComment(String comment);

	boolean isSpoiler();

	void setSpoiler(boolean spoiler);

	boolean isReview();

	void setReview(boolean review);

	Integer getReplies();

	void setReplies(Integer replies);

	Integer getLikes();

	void setLikes(Integer likes);

	Float getUserRating();

	void setUserRating(Float userRating);

	TraktUser getUser();

	void setUser(TraktUser user);
}
