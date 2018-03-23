package media.thehoard.thirdparty.api.trakt.objects.get.calendars;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.time.Instant;
import java.util.Date;

public interface TraktCalendarShow extends TraktShow<TraktCalendarShow>, TraktCalendarEpisode<TraktCalendarShow> {
	Instant getFirstAired();

	void setFirstAired(Instant firstAired);

	TraktCalendarShow withFirstAired(Instant firstAired);

	TraktEpisode getEpisode();

	void setEpisode(TraktEpisodeImpl episode);

	TraktCalendarShow withEpisode(TraktEpisodeImpl episode);

	TraktShow getShow();

	void setShow(TraktShowImpl show);

	TraktCalendarShow withShow(TraktShowImpl show);
}
