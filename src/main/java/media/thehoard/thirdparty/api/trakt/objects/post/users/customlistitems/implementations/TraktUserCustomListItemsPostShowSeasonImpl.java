package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations;

import java.util.List;

public class TraktUserCustomListItemsPostShowSeasonImpl {
	private int number;
	private List<TraktUserCustomListItemsPostShowEpisodeImpl> episodes;

	public TraktUserCustomListItemsPostShowSeasonImpl() {}

	public TraktUserCustomListItemsPostShowSeasonImpl(int season) {
		this.number = season;
	}
}
