package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl;

import java.util.List;

public class TraktUserCustomListItemsPostShowImpl {
	private TraktShowIdsImpl ids;
	private List<TraktUserCustomListItemsPostShowSeasonImpl> seasons;

	public TraktUserCustomListItemsPostShowImpl() {}

	public TraktUserCustomListItemsPostShowImpl(TraktShowIdsImpl ids) {
		this.ids = ids;
	}
}
