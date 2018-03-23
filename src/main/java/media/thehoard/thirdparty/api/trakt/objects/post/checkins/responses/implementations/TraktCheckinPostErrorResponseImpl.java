package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.TraktCheckinPostErrorResponse;

import java.time.Instant;

public class TraktCheckinPostErrorResponseImpl implements TraktCheckinPostErrorResponse {
	@SerializedName("expires_at")
	private Instant expiresAt;

	@Override
	public Instant getExpiresAt() {
		return expiresAt;
	}

	@Override
	public void setExpiresAt(Instant expiresAt) {
		this.expiresAt = expiresAt;
	}

	@Override
	public TraktCheckinPostErrorResponse withExpiresAt(Instant expiresAt) {
		this.expiresAt = expiresAt;
		return this;
	}
}
