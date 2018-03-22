package media.thehoard.thirdparty.api.trakt.objects.get.collections;

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktMetadata;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;

import java.util.Date;

public interface TraktCollectionMovie extends TraktMovie<TraktCollectionMovie> {
	Date getCollectedAt();

	void setCollectedAt(Date collectedAt);

	TraktCollectionMovie withCollectedAt(Date collectedAt);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktCollectionMovie withMovie(TraktMovieImpl movie);

	TraktMetadata getMetadata();

	void setMetadata(TraktMetadataImpl metadata);

	TraktCollectionMovie withMetadata(TraktMetadataImpl metadata);
}
