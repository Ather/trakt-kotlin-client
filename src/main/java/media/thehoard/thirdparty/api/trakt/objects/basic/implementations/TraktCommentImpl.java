package media.thehoard.thirdparty.api.trakt.objects.basic.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktComment;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser;

import java.util.Date;

public class TraktCommentImpl implements TraktComment {
	private int id;
	private Integer parentId;
	@SerializedName("created_at")
	private Date createdAt;
	@SerializedName("updated_at")
	private Date updatedAt;
	private String comment;
	private boolean spoiler;
	private boolean review;
	private Integer replies;
	private Integer likes;
	@SerializedName("user_rating")
	private Float userRating;
	private TraktUser user;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public Integer getParentId() {
		return parentId;
	}

	@Override
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Override
	public Date getCreatedAt() {
		return createdAt;
	}

	@Override
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public Date getUpdatedAt() {
		return updatedAt;
	}

	@Override
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public boolean isSpoiler() {
		return spoiler;
	}

	@Override
	public void setSpoiler(boolean spoiler) {
		this.spoiler = spoiler;
	}

	@Override
	public boolean isReview() {
		return review;
	}

	@Override
	public void setReview(boolean review) {
		this.review = review;
	}

	@Override
	public Integer getReplies() {
		return replies;
	}

	@Override
	public void setReplies(Integer replies) {
		this.replies = replies;
	}

	@Override
	public Integer getLikes() {
		return likes;
	}

	@Override
	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	@Override
	public Float getUserRating() {
		return userRating;
	}

	@Override
	public void setUserRating(Float userRating) {
		this.userRating = userRating;
	}

	@Override
	public TraktUser getUser() {
		return user;
	}

	@Override
	public void setUser(TraktUser user) {
		this.user = user;
	}
}
