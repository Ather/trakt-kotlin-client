package media.thehoard.thirdparty.api.trakt.objects.get.collections;

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktMetadata;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;

import java.time.Instant;

public interface TraktCollectionMovie extends TraktMovie<TraktCollectionMovie> {
	Instant getCollectedAt();

	void setCollectedAt(Instant collectedAt);

	TraktCollectionMovie withCollectedAt(Instant collectedAt);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktCollectionMovie withMovie(TraktMovieImpl movie);

	TraktMetadata getMetadata();

	void setMetadata(TraktMetadataImpl metadata);

	TraktCollectionMovie withMetadata(TraktMetadataImpl metadata);
}
