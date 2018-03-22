package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.enums.TraktReleaseType;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieRelease;

import java.util.Date;

public class TraktMovieReleaseImpl implements TraktMovieRelease {
	private String country;
	private String certification;
	@SerializedName("release_date")
	private Date releaseDate;
	@SerializedName("release_type")
	private TraktReleaseType releaseType;
	private String note;

	@Override
	public String getCountry() {
		return country;
	}

	@Override
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public TraktMovieRelease withCountry(String country) {
		this.country = country;
		return this;
	}

	@Override
	public String getCertification() {
		return certification;
	}

	@Override
	public void setCertification(String certification) {
		this.certification = certification;
	}

	@Override
	public TraktMovieRelease withCertification(String certification) {
		this.certification = certification;
		return this;
	}

	@Override
	public Date getReleaseDate() {
		return releaseDate;
	}

	@Override
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public TraktMovieRelease withReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
		return this;
	}

	@Override
	public TraktReleaseType getReleaseType() {
		return releaseType;
	}

	@Override
	public void setReleaseType(TraktReleaseType releaseType) {
		this.releaseType = releaseType;
	}

	@Override
	public TraktMovieRelease withReleaseType(TraktReleaseType releaseType) {
		this.releaseType = releaseType;
		return this;
	}

	@Override
	public String getNote() {
		return note;
	}

	@Override
	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public TraktMovieRelease withNote(String note) {
		this.note = note;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktMovieReleaseImpl that = (TraktMovieReleaseImpl) o;

		if (country != null ? !country.equals(that.country) : that.country != null) {return false;}
		return (certification != null ? certification.equals(that.certification) : that.certification == null) && (
				releaseDate != null ? releaseDate.equals(that.releaseDate)
						: that.releaseDate == null) && releaseType == that.releaseType && (note != null ? note
				.equals(that.note) : that.note == null);
	}

	@Override
	public int hashCode() {
		int result = country != null ? country.hashCode() : 0;
		result = 31 * result + (certification != null ? certification.hashCode() : 0);
		result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
		result = 31 * result + (releaseType != null ? releaseType.hashCode() : 0);
		result = 31 * result + (note != null ? note.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktMovieRelease{" + "country='" + country + '\'' + ", certification='" + certification + '\'' + ", releaseDate=" + releaseDate + ", releaseType=" + releaseType + ", note='" + note + '\'' + '}';
	}
}
