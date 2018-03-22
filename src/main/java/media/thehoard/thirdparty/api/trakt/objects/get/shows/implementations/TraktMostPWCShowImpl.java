package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktMostPWCShow;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;

public class TraktMostPWCShowImpl implements TraktMostPWCShow {
	@SerializedName("watcher_count")
	private Integer watcherCount;
	@SerializedName("play_count")
	private Integer playCount;
	@SerializedName("collected_count")
	private Integer collectedCount;
	@SerializedName("collector_count")
	private Integer collectorCount;
	private TraktShowImpl show;

	@Override
	public Integer getWatcherCount() {
		return watcherCount;
	}

	@Override
	public void setWatcherCount(Integer watcherCount) {
		this.watcherCount = watcherCount;
	}

	@Override
	public TraktMostPWCShow withWatcherCount(Integer watcherCount) {
		this.watcherCount = watcherCount;
		return this;
	}

	@Override
	public Integer getPlayCount() {
		return playCount;
	}

	@Override
	public void setPlayCount(Integer playCount) {
		this.playCount = playCount;
	}

	@Override
	public TraktMostPWCShow withPlayCount(Integer playCount) {
		this.playCount = playCount;
		return this;
	}

	@Override
	public Integer getCollectedCount() {
		return collectedCount;
	}

	@Override
	public void setCollectedCount(Integer collectedCount) {
		this.collectedCount = collectedCount;
	}

	@Override
	public TraktMostPWCShow withCollectedCount(Integer collectedCount) {
		this.collectedCount = collectedCount;
		return this;
	}

	@Override
	public Integer getCollectorCount() {
		return collectorCount;
	}

	@Override
	public void setCollectorCount(Integer collectorCount) {
		this.collectorCount = collectorCount;
	}

	@Override
	public TraktMostPWCShow withCollectorCount(Integer collectorCount) {
		this.collectorCount = collectorCount;
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
	public TraktMostPWCShow withShow(TraktShowImpl show) {
		this.show = show;
		return this;
	}

	@Override
	public String getTitle() {
		return show != null ? show.getTitle() : null;
	}

	@Override
	public void setTitle(String title) {
		if (show != null)
			show.setTitle(title);
	}

	@Override
	public TraktMostPWCShowImpl withTitle(String title) {
		if (show != null)
			show.setTitle(title);
		return this;
	}

	@Override
	public Integer getYear() {
		return show != null ? show.getYear() : null;
	}

	@Override
	public void setYear(Integer year) {
		if (show != null)
			show.setYear(year);
	}

	@Override
	public TraktMostPWCShowImpl withYear(Integer year) {
		if (show != null)
			show.setYear(year);
		return this;
	}

	@Override
	public TraktShowIdsImpl getIds() {
		return show != null ? show.getIds() : null;
	}

	@Override
	public void setIds(TraktShowIdsImpl ids) {
		if (show != null)
			show.setIds(ids);
	}

	@Override
	public TraktMostPWCShowImpl withIds(TraktShowIdsImpl ids) {
		if (show != null)
			show.setIds(ids);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktMostPWCShowImpl that = (TraktMostPWCShowImpl) o;

		return (watcherCount != null ? watcherCount.equals(that.watcherCount) : that.watcherCount == null) && (
				playCount != null ? playCount.equals(that.playCount) : that.playCount == null) && (
				collectedCount != null ? collectedCount.equals(that.collectedCount) : that.collectedCount == null) && (
				collectorCount != null ? collectorCount.equals(that.collectorCount) : that.collectorCount == null) && (
				show != null ? show.equals(that.show) : that.show == null);
	}

	@Override
	public int hashCode() {
		int result = watcherCount != null ? watcherCount.hashCode() : 0;
		result = 31 * result + (playCount != null ? playCount.hashCode() : 0);
		result = 31 * result + (collectedCount != null ? collectedCount.hashCode() : 0);
		result = 31 * result + (collectorCount != null ? collectorCount.hashCode() : 0);
		result = 31 * result + (show != null ? show.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktMostPWCShowImpl{" + "watcherCount=" + watcherCount + ", playCount=" + playCount + ", collectedCount=" + collectedCount + ", collectorCount=" + collectorCount + ", show=" + show + '}';
	}
}
