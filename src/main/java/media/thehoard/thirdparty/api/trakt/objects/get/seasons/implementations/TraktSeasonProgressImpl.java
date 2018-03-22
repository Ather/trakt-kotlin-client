package media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonProgress;

public class TraktSeasonProgressImpl implements TraktSeasonProgress {
	private Integer number;
	private Integer aired;
	private Integer completed;

	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public TraktSeasonProgress withNumber(Integer number) {
		this.number = number;
		return this;
	}

	@Override
	public Integer getAired() {
		return aired;
	}

	@Override
	public void setAired(Integer aired) {
		this.aired = aired;
	}

	@Override
	public TraktSeasonProgress withAired(Integer aired) {
		this.aired = aired;
		return this;
	}

	@Override
	public Integer getCompleted() {
		return completed;
	}

	@Override
	public void setCompleted(Integer completed) {
		this.completed = completed;
	}

	@Override
	public TraktSeasonProgress withCompleted(Integer completed) {
		this.completed = completed;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktSeasonProgressImpl that = (TraktSeasonProgressImpl) o;

		return (number != null ? number.equals(that.number) : that.number == null) && (aired != null ? aired
				.equals(that.aired) : that.aired == null) && (completed != null ? completed.equals(that.completed)
				: that.completed == null);
	}

	@Override
	public int hashCode() {
		int result = number != null ? number.hashCode() : 0;
		result = 31 * result + (aired != null ? aired.hashCode() : 0);
		result = 31 * result + (completed != null ? completed.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktSeasonProgress{" + "number=" + number + ", aired=" + aired + ", completed=" + completed + '}';
	}
}
