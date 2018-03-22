package media.thehoard.thirdparty.api.trakt.objects.get.shows;

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

public interface TraktMostAnticipiatedShow extends TraktShow<TraktMostAnticipiatedShow> {
	Integer getListCount();

	void setListCount(Integer listCount);

	TraktMostAnticipiatedShow withListCount(Integer listCount);

	TraktShow getShow();

	void setShow(TraktShowImpl show);

	TraktMostAnticipiatedShow withShow(TraktShowImpl show);
}
