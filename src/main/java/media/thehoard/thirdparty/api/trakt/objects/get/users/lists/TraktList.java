package media.thehoard.thirdparty.api.trakt.objects.get.users.lists;

import media.thehoard.thirdparty.api.trakt.enums.TraktAccessScope;
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListIdsImpl;

import java.util.Date;

public interface TraktList {
	String getName();

	void setName(String name);

	TraktList withName(String name);

	String getDescription();

	void setDescription(String description);

	TraktList withDescription(String description);

	TraktAccessScope getPrivacy();

	void setPrivacy(TraktAccessScope privacy);

	TraktList withPrivacy(TraktAccessScope privacy);

	Boolean getDisplayNumbers();

	void setDisplayNumbers(Boolean displayNumbers);

	TraktList withDisplayNumbers(Boolean displayNumbers);

	Boolean getAllowComments();

	void setAllowComments(Boolean allowComments);

	TraktList withAllowComments(Boolean allowComments);

	String getSortBy();

	void setSortBy(String sortBy);

	TraktList withSortBy(String sortBy);

	String getSortHow();

	void setSortHow(String sortHow);

	TraktList withSortHow(String sortHow);

	Date getCreatedAt();

	void setCreatedAt(Date createdAt);

	TraktList withCreatedAt(Date createdAt);

	Date getUpdatedAt();

	void setUpdatedAt(Date updatedAt);

	TraktList withUpdatedAt(Date updatedAt);

	Integer getItemCount();

	void setItemCount(Integer itemCount);

	TraktList withItemCount(Integer itemCount);

	Integer getCommentCount();

	void setCommentCount(Integer commentCount);

	TraktList withCommentCount(Integer commentCount);

	Integer getLikes();

	void setLikes(Integer likes);

	TraktList withLikes(Integer likes);

	TraktListIdsImpl getIds();

	void setIds(TraktListIdsImpl ids);

	TraktList withIds(TraktListIdsImpl ids);

	TraktUserImpl getUser();

	void setUser(TraktUserImpl user);

	TraktList withUser(TraktUserImpl user);
}
