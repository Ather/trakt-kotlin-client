package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserFollowRequest;

import java.time.Instant;

public class TraktUserFollowRequestImpl implements TraktUserFollowRequest {
	private int id;
	@SerializedName("requested_at")
	private Instant requestedAt;
	private TraktUserImpl user;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public TraktUserFollowRequest withId(int id) {
		this.id = id;
		return this;
	}

	@Override
	public Instant getRequestedAt() {
		return requestedAt;
	}

	@Override
	public void setRequestedAt(Instant requestedAt) {
		this.requestedAt = requestedAt;
	}

	@Override
	public TraktUserFollowRequest withRequestedAt(Instant requestedAt) {
		this.requestedAt = requestedAt;
		return this;
	}

	@Override
	public TraktUser getUser() {
		return user;
	}

	@Override
	public void setUser(TraktUserImpl user) {
		this.user = user;
	}

	@Override
	public TraktUserFollowRequest withUser(TraktUserImpl user) {
		this.user = user;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserFollowRequestImpl that = (TraktUserFollowRequestImpl) o;

		if (id != that.id) return false;
		if (requestedAt != null ? !requestedAt.equals(that.requestedAt) : that.requestedAt != null) return false;
		return user != null ? user.equals(that.user) : that.user == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (requestedAt != null ? requestedAt.hashCode() : 0);
		result = 31 * result + (user != null ? user.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktUserFollowRequest{" + "id=" + id + ", requestedAt=" + requestedAt + ", user=" + user + '}';
	}
}
