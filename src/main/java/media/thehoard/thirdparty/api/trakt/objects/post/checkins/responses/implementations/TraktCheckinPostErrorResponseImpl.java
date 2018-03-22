package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.TraktCheckinPostErrorResponse;

import java.util.Date;

public class TraktCheckinPostErrorResponseImpl implements TraktCheckinPostErrorResponse {
	@SerializedName("expires_at")
	private Date expiresAt;

	@Override
	public Date getExpiresAt() {
		return expiresAt;
	}

	@Override
	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	@Override
	public TraktCheckinPostErrorResponse withExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
		return this;
	}
}
