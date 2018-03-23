package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.enums.TraktUserLikeType;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList;

import java.time.Instant;

public interface TraktUserLikeItem {
	Instant getLikedAt();

	void setLikedAt(Instant likedAt);

	TraktUserLikeItem withLikedAt(Instant likedAt);

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
