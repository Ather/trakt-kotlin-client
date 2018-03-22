package media.thehoard.thirdparty.api.trakt.objects.get.episodes;

public interface TraktEpisodeProgress<T extends TraktEpisodeProgress<T>> {
	Integer getNumber();

	void setNumber(Integer number);

	T withNumber(Integer number);

	Boolean getCompleted();

	void setCompleted(Boolean completed);

	T withCompleted(Boolean completed);
}
