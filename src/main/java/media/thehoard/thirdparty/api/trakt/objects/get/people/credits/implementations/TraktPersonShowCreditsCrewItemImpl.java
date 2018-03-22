package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCreditsCrewItem;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

public class TraktPersonShowCreditsCrewItemImpl implements TraktPersonShowCreditsCrewItem {
	private String job;
	private TraktShowImpl show;

	@Override
	public String getJob() {
		return job;
	}

	@Override
	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public TraktPersonShowCreditsCrewItemImpl withJob(String job) {
		this.job = job;
		return this;
	}

	@Override
	public TraktShow getShow() {
		return show;
	}

	@Override
	public void setShow(TraktShowImpl show) {
		this.show = show;
	}

	@Override
	public TraktPersonShowCreditsCrewItemImpl withShow(TraktShowImpl show) {
		this.show = show;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktPersonShowCreditsCrewItemImpl that = (TraktPersonShowCreditsCrewItemImpl) o;

		return (job != null ? job.equals(that.job) : that.job == null) && (show != null ? show.equals(that.show)
				: that.show == null);
	}

	@Override
	public int hashCode() {
		int result = job != null ? job.hashCode() : 0;
		result = 31 * result + (show != null ? show.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktPersonShowCreditsCrewItemImpl{" + "job='" + job + '\'' + ", show=" + show + '}';
	}
}
