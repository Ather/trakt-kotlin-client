package media.thehoard.thirdparty.api.trakt.objects.get.seasons;

public interface TraktSeasonProgress<T extends TraktSeasonProgress<T>> {
	Integer getNumber();

	void setNumber(Integer number);

	T withNumber(Integer number);

	Integer getAired();

	void setAired(Integer aired);

	T withAired(Integer aired);

	Integer getCompleted();

	void setCompleted(Integer completed);

	T withCompleted(Integer completed);
}
