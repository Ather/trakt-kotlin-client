package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.enums.TraktUserLikeType;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList;

import java.util.Date;

public interface TraktUserLikeItem {
	Date getLikedAt();

	void setLikedAt(Date likedAt);

	TraktUserLikeItem withLikedAt(Date likedAt);

	TraktUserLikeType getType();

	void setType(TraktUserLikeType type);

	TraktUserLikeItem withType(TraktUserLikeType type);

	TraktCommentImpl getComment();

	void setComment(TraktCommentImpl comment);

	TraktUserLikeItem withComment(TraktCommentImpl comment);

	TraktList getList();

	void setList(TraktList list);

	TraktUserLikeItem withList(TraktList list);
}
