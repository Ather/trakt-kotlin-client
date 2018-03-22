package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCreditsCastItem;

public class TraktPersonMovieCreditsCastItemImpl implements TraktPersonMovieCreditsCastItem {
	private String character;
	private TraktMovieImpl movie;

	@Override
	public String getCharacter() {
		return character;
	}

	@Override
	public void setCharacter(String character) {
		this.character = character;
	}

	@Override
	public TraktPersonMovieCreditsCastItemImpl withCharacter(String character) {
		this.character = character;
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
	public TraktPersonMovieCreditsCastItemImpl withMovie(TraktMovieImpl movie) {
		this.movie = movie;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktPersonMovieCreditsCastItemImpl that = (TraktPersonMovieCreditsCastItemImpl) o;

		return (character != null ? character.equals(that.character) : that.character == null) && (movie != null ? movie
				.equals(that.movie) : that.movie == null);
	}

	@Override
	public int hashCode() {
		int result = character != null ? character.hashCode() : 0;
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktPersonMovieCreditsCastItemImpl{" + "character='" + character + '\'' + ", movie=" + movie + '}';
	}
}
