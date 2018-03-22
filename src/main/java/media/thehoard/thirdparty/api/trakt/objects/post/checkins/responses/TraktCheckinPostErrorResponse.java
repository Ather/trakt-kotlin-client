package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses;

import java.util.Date;

public interface TraktCheckinPostErrorResponse {
	Date getExpiresAt();

	void setExpiresAt(Date expiresAt);

	TraktCheckinPostErrorResponse withExpiresAt(Date expiresAt);
}
