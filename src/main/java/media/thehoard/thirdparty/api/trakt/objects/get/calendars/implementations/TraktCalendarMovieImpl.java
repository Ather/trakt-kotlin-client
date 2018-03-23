package media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.calendars.TraktCalendarMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;

import java.time.Instant;
import java.util.Date;

public class TraktCalendarMovieImpl implements TraktCalendarMovie {
	private Instant released;
	private TraktMovieImpl movie;

	@Override
	public Instant getReleased() {
		return released;
	}

	@Override
	public void setReleased(Instant released) {
		this.released = released;
	}

	@Override
	public TraktCalendarMovie withReleased(Instant released) {
		this.released = released;
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
	public TraktCalendarMovie withMovie(TraktMovieImpl movie) {
		this.movie = movie;
		return this;
	}

	@Override
	public String getTitle() {
		return movie != null ? movie.getTitle() : null;
	}

	@Override
	public void setTitle(String title) {
		if (movie != null) movie.setTitle(title);
	}

	@Override
	public TraktCalendarMovie withTitle(String title) {
		if (movie != null) movie.setTitle(title);
		return this;
	}

	@Override
	public Integer getYear() {
		return movie != null ? movie.getYear() : null;
	}

	@Override
	public void setYear(Integer year) {
		if (movie != null) movie.setYear(year);
	}

	@Override
	public TraktCalendarMovie withYear(Integer year) {
		if (movie != null) movie.setYear(year);
		return this;
	}

	@Override
	public TraktMovieIds getIds() {
		return movie != null ? movie.getIds() : null;
	}

	@Override
	public void setIds(TraktMovieIds ids) {
		if (movie != null) movie.setIds(ids);
	}

	@Override
	public TraktCalendarMovie withIds(TraktMovieIds ids) {
		if (movie != null) movie.setIds(ids);
		return this;
	}
}
