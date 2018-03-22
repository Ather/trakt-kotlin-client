package media.thehoard.thirdparty.api.trakt.objects.get.people.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPersonExtended;

import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class TraktPersonExtendedImpl implements TraktPersonExtended {
	private String name;
	private TraktPersonIdsImpl ids;

	private String biography;
	private Date birthday;
	private Date death;
	private String birthplace;
	private String homepage;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public TraktPersonExtendedImpl withName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public TraktPersonIdsImpl getIds() {
		return ids;
	}

	@Override
	public void setIds(TraktPersonIdsImpl ids) {
		this.ids = ids;
	}

	@Override
	public TraktPersonExtendedImpl withIds(TraktPersonIdsImpl ids) {
		this.ids = ids;
		return this;
	}

	@Override
	public String getBiography() {
		return biography;
	}

	@Override
	public void setBiography(String biography) {
		this.biography = biography;
	}

	@Override
	public TraktPersonExtendedImpl withBiography(String biography) {
		this.biography = biography;
		return this;
	}

	@Override
	public Date getBirthday() {
		return birthday;
	}

	@Override
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public TraktPersonExtendedImpl withBirthday(Date birthday) {
		this.birthday = birthday;
		return this;
	}

	@Override
	public Date getDeath() {
		return death;
	}

	@Override
	public void setDeath(Date death) {
		this.death = death;
	}

	@Override
	public TraktPersonExtendedImpl withDeath(Date death) {
		this.death = death;
		return this;
	}

	@Override
	public String getBirthplace() {
		return birthplace;
	}

	@Override
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	@Override
	public TraktPersonExtendedImpl withBirthplace(String birthplace) {
		this.birthplace = birthplace;
		return this;
	}

	@Override
	public String getHomepage() {
		return homepage;
	}

	@Override
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	@Override
	public TraktPersonExtendedImpl withHomepage(String homepage) {
		this.homepage = homepage;
		return this;
	}

	@Override
	public int getAge() {
		return birthday != null ? (death != null ? Period
				.between(birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), death.toInstant()
						.atZone(ZoneId.systemDefault()).toLocalDate()).getYears()
				: Period.between(birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), Instant.now()
						.atZone(ZoneId.systemDefault()).toLocalDate()).getYears()) : 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktPersonExtendedImpl that = (TraktPersonExtendedImpl) o;

		return (name != null ? name.equals(that.name) : that.name == null) && (ids != null ? ids.equals(that.ids)
				: that.ids == null) && (biography != null ? biography.equals(that.biography)
				: that.biography == null) && (birthday != null ? birthday.equals(that.birthday)
				: that.birthday == null) && (death != null ? death.equals(that.death) : that.death == null) && (
				birthplace != null ? birthplace.equals(that.birthplace) : that.birthplace == null) && (homepage != null
				? homepage.equals(that.homepage) : that.homepage == null);
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (ids != null ? ids.hashCode() : 0);
		result = 31 * result + (biography != null ? biography.hashCode() : 0);
		result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
		result = 31 * result + (death != null ? death.hashCode() : 0);
		result = 31 * result + (birthplace != null ? birthplace.hashCode() : 0);
		result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktPersonExtended{" + "name='" + name + '\'' + ", ids=" + ids + ", biography='" + biography + '\'' + ", birthday=" + birthday + ", death=" + death + ", birthplace='" + birthplace + '\'' + ", homepage='" + homepage + '\'' + '}';
	}
}
