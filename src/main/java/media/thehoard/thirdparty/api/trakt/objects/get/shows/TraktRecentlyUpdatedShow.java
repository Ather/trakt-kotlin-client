package media.thehoard.thirdparty.api.trakt.objects.get.shows;

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.time.Instant;

public interface TraktRecentlyUpdatedShow extends TraktShow<TraktRecentlyUpdatedShow> {
	Instant getUpdatedAt();

	void setUpdatedAt(Instant updatedAt);

	TraktRecentlyUpdatedShow withUpdatedAt(Instant updatedAt);

	TraktShow getShow();

	void setShow(TraktShowImpl show);

	TraktRecentlyUpdatedShow withShow(TraktShowImpl show);
}
