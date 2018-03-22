package media.thehoard.thirdparty.api.trakt.objects.basic;

public interface TraktStatistics {
	Integer getWatchers();

	void setWatchers(Integer watchers);

	Integer getPlays();

	void setPlays(Integer plays);

	Integer getCollectors();

	void setCollectors(Integer collectors);

	Integer getCollectedEpisodes();

	void setCollectedEpisodes(Integer collectedEpisodes);

	Integer getComments();

	void setComments(Integer comments);

	Integer getLists();

	void setLists(Integer lists);

	Integer getVotes();

	void setVotes(Integer votes);
}
