package media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.enums.TraktAccessScope;
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList;

import java.time.Instant;

public class TraktListImpl implements TraktList {
	private String name;
	private String description;
	private TraktAccessScope privacy;
	@SerializedName("display_numbers")
	private Boolean displayNumbers;
	@SerializedName("allow_comments")
	private Boolean allowComments;
	//TODO Consider using the SortBy and SortHow enums.
	@SerializedName("sort_by")
	private String sortBy;
	@SerializedName("sort_how")
	private String sortHow;
	@SerializedName("created_at")
	private Instant createdAt;
	@SerializedName("updated_at")
	private Instant updatedAt;
	@SerializedName("item_count")
	private Integer itemCount;
	@SerializedName("comment_count")
	private Integer commentCount;
	private Integer likes;
	private TraktListIdsImpl ids;
	private TraktUserImpl user;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public TraktList withName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public TraktList withDescription(String description) {
		this.description = description;
		return this;
	}

	@Override
	public TraktAccessScope getPrivacy() {
		return privacy;
	}

	@Override
	public void setPrivacy(TraktAccessScope privacy) {
		this.privacy = privacy;
	}

	@Override
	public TraktList withPrivacy(TraktAccessScope privacy) {
		this.privacy = privacy;
		return this;
	}

	@Override
	public Boolean getDisplayNumbers() {
		return displayNumbers;
	}

	@Override
	public void setDisplayNumbers(Boolean displayNumbers) {
		this.displayNumbers = displayNumbers;
	}

	@Override
	public TraktList withDisplayNumbers(Boolean displayNumbers) {
		this.displayNumbers = displayNumbers;
		return this;
	}

	@Override
	public Boolean getAllowComments() {
		return allowComments;
	}

	@Override
	public void setAllowComments(Boolean allowComments) {
		this.allowComments = allowComments;
	}

	@Override
	public TraktList withAllowComments(Boolean allowComments) {
		this.allowComments = allowComments;
		return this;
	}

	@Override
	public String getSortBy() {
		return sortBy;
	}

	@Override
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	@Override
	public TraktList withSortBy(String sortBy) {
		this.sortBy = sortBy;
		return this;
	}

	@Override
	public String getSortHow() {
		return sortHow;
	}

	@Override
	public void setSortHow(String sortHow) {
		this.sortHow = sortHow;
	}

	@Override
	public TraktList withSortHow(String sortHow) {
		this.sortHow = sortHow;
		return this;
	}

	@Override
	public Instant getCreatedAt() {
		return createdAt;
	}

	@Override
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public TraktList withCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	@Override
	public Instant getUpdatedAt() {
		return updatedAt;
	}

	@Override
	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public TraktList withUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

	@Override
	public Integer getItemCount() {
		return itemCount;
	}

	@Override
	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}

	@Override
	public TraktList withItemCount(Integer itemCount) {
		this.itemCount = itemCount;
		return this;
	}

	@Override
	public Integer getCommentCount() {
		return commentCount;
	}

	@Override
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public TraktList withCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
		return this;
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
	public TraktList withLikes(Integer likes) {
		this.likes = likes;
		return this;
	}

	@Override
	public TraktListIdsImpl getIds() {
		return ids;
	}

	@Override
	public void setIds(TraktListIdsImpl ids) {
		this.ids = ids;
	}

	@Override
	public TraktList withIds(TraktListIdsImpl ids) {
		this.ids = ids;
		return this;
	}

	@Override
	public TraktUserImpl getUser() {
		return user;
	}

	@Override
	public void setUser(TraktUserImpl user) {
		this.user = user;
	}

	@Override
	public TraktList withUser(TraktUserImpl user) {
		this.user = user;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktListImpl traktList = (TraktListImpl) o;

		if (name != null ? !name.equals(traktList.name) : traktList.name != null) return false;
		if (description != null ? !description.equals(traktList.description) : traktList.description != null)
			return false;
		if (privacy != traktList.privacy) return false;
		if (displayNumbers != null ? !displayNumbers.equals(traktList.displayNumbers)
				: traktList.displayNumbers != null) return false;
		if (allowComments != null ? !allowComments.equals(traktList.allowComments) : traktList.allowComments != null)
			return false;
		if (sortBy != null ? !sortBy.equals(traktList.sortBy) : traktList.sortBy != null) return false;
		if (sortHow != null ? !sortHow.equals(traktList.sortHow) : traktList.sortHow != null) return false;
		if (createdAt != null ? !createdAt.equals(traktList.createdAt) : traktList.createdAt != null) return false;
		if (updatedAt != null ? !updatedAt.equals(traktList.updatedAt) : traktList.updatedAt != null) return false;
		if (itemCount != null ? !itemCount.equals(traktList.itemCount) : traktList.itemCount != null) return false;
		if (commentCount != null ? !commentCount.equals(traktList.commentCount) : traktList.commentCount != null)
			return false;
		if (likes != null ? !likes.equals(traktList.likes) : traktList.likes != null) return false;
		if (ids != null ? !ids.equals(traktList.ids) : traktList.ids != null) return false;
		return user != null ? user.equals(traktList.user) : traktList.user == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (privacy != null ? privacy.hashCode() : 0);
		result = 31 * result + (displayNumbers != null ? displayNumbers.hashCode() : 0);
		result = 31 * result + (allowComments != null ? allowComments.hashCode() : 0);
		result = 31 * result + (sortBy != null ? sortBy.hashCode() : 0);
		result = 31 * result + (sortHow != null ? sortHow.hashCode() : 0);
		result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
		result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
		result = 31 * result + (itemCount != null ? itemCount.hashCode() : 0);
		result = 31 * result + (commentCount != null ? commentCount.hashCode() : 0);
		result = 31 * result + (likes != null ? likes.hashCode() : 0);
		result = 31 * result + (ids != null ? ids.hashCode() : 0);
		result = 31 * result + (user != null ? user.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktList{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", privacy=" + privacy + ", displayNumbers=" + displayNumbers + ", allowComments=" + allowComments + ", sortBy='" + sortBy + '\'' + ", sortHow='" + sortHow + '\'' + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", itemCount=" + itemCount + ", commentCount=" + commentCount + ", likes=" + likes + ", ids=" + ids + ", user=" + user + '}';
	}
}
