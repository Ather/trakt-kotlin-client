package media.thehoard.thirdparty.api.trakt.objects.get.shows;

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.util.Date;

public interface TraktRecentlyUpdatedShow extends TraktShow<TraktRecentlyUpdatedShow> {
	Date getUpdatedAt();

	void setUpdatedAt(Date updatedAt);

	TraktRecentlyUpdatedShow withUpdatedAt(Date updatedAt);

	TraktShow getShow();

	void setShow(TraktShowImpl show);

	TraktRecentlyUpdatedShow withShow(TraktShowImpl show);
}
