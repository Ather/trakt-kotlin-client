package media.thehoard.thirdparty.api.trakt.objects.get.watched;

import java.util.Date;

public interface TraktWatchedShowEpisode {
	Integer getNumber();

	void setNumber(Integer number);

	TraktWatchedShowEpisode withNumber(Integer number);

	Integer getPlays();

	void setPlays(Integer plays);

	TraktWatchedShowEpisode withPlays(Integer plays);

	Date getLastWatchedAt();

	void setLastWatchedAt(Date lastWatchedAt);

	TraktWatchedShowEpisode withLastWatchedAt(Date lastWatchedAt);
}
