package media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeProgress;

public class TraktEpisodeProgressImpl implements TraktEpisodeProgress {
	private Integer number;
	private Boolean completed;

	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public TraktEpisodeProgress withNumber(Integer number) {
		this.number = number;
		return this;
	}

	@Override
	public Boolean getCompleted() {
		return completed;
	}

	@Override
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	@Override
	public TraktEpisodeProgress withCompleted(Boolean completed) {
		this.completed = completed;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktEpisodeProgressImpl that = (TraktEpisodeProgressImpl) o;

		return (number != null ? number.equals(that.number) : that.number == null) && (completed != null ? completed
				.equals(that.completed) : that.completed == null);
	}

	@Override
	public int hashCode() {
		int result = number != null ? number.hashCode() : 0;
		result = 31 * result + (completed != null ? completed.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktEpisodeProgress{" + "number=" + number + ", completed=" + completed + '}';
	}
}
