package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses;

import java.time.Instant;

public interface TraktCheckinPostErrorResponse {
	Instant getExpiresAt();

	void setExpiresAt(Instant expiresAt);

	TraktCheckinPostErrorResponse withExpiresAt(Instant expiresAt);
}
