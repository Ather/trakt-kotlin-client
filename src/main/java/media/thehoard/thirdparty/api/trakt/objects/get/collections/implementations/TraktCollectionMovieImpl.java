package media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktMetadata;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;

import java.util.Date;

public class TraktCollectionMovieImpl implements TraktCollectionMovie {
	@SerializedName("collected_at")
	private Date collectedAt;
	private TraktMovieImpl movie;
	private TraktMetadataImpl metadata;

	@Override
	public String getTitle() {return movie != null ? movie.getTitle() : null;}

	@Override
	public void setTitle(String title) {if (movie != null) movie.setTitle(title);}

	@Override
	public TraktCollectionMovieImpl withTitle(String title) {
		if (movie != null) movie.setTitle(title);
		return this;
	}

	@Override
	public Integer getYear() {return movie != null ? movie.getYear() : null;}

	@Override
	public void setYear(Integer year) {if (movie != null) movie.setYear(year);}

	@Override
	public TraktCollectionMovieImpl withYear(Integer year) {
		if (movie == null) movie.setYear(year);
		return this;
	}

	@Override
	public TraktMovieIds getIds() {return movie != null ? movie.getIds() : null;}

	@Override
	public void setIds(TraktMovieIds ids) {if (movie != null) movie.setIds(ids);}

	@Override
	public TraktCollectionMovieImpl withIds(TraktMovieIds ids) {
		if (movie != null) movie.setIds(ids);
		return this;
	}

	@Override
	public Date getCollectedAt() {
		return collectedAt;
	}

	@Override
	public void setCollectedAt(Date collectedAt) {
		this.collectedAt = collectedAt;
	}

	@Override
	public TraktCollectionMovie withCollectedAt(Date collectedAt) {
		this.collectedAt = collectedAt;
		return this;
	}

	@Override
	public TraktMovieImpl getMovie() {
		return movie;
	}

	@Override
	public void setMovie(TraktMovieImpl movie) {
		this.movie = movie;
	}

	@Override
	public TraktCollectionMovie withMovie(TraktMovieImpl movie) {
		this.movie = movie;
		return this;
	}

	@Override
	public TraktMetadata getMetadata() {
		return metadata;
	}

	@Override
	public void setMetadata(TraktMetadataImpl metadata) {
		this.metadata = metadata;
	}

	@Override
	public TraktCollectionMovie withMetadata(TraktMetadataImpl metadata) {
		this.metadata = metadata;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktCollectionMovieImpl that = (TraktCollectionMovieImpl) o;

		if (collectedAt != null ? !collectedAt.equals(that.collectedAt) : that.collectedAt != null) return false;
		if (movie != null ? !movie.equals(that.movie) : that.movie != null) return false;
		return metadata != null ? metadata.equals(that.metadata) : that.metadata == null;
	}

	@Override
	public int hashCode() {
		int result = collectedAt != null ? collectedAt.hashCode() : 0;
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		result = 31 * result + (metadata != null ? metadata.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktCollectionMovie{" + "collectedAt=" + collectedAt + ", movie=" + movie + ", metadata=" + metadata + '}';
	}
}
