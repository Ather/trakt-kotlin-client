package media.thehoard.thirdparty.api.trakt.objects.basic.implementations;

public class TraktSharingImpl implements media.thehoard.thirdparty.api.trakt.objects.basic.TraktSharing {
	private Boolean facebook;
	private Boolean twitter;
	private Boolean google;
	private Boolean tumblr;
	private Boolean medium;
	private Boolean slack;

	@Override
	public Boolean getFacebook() {
		return facebook;
	}

	@Override
	public void setFacebook(Boolean facebook) {
		this.facebook = facebook;
	}

	@Override
	public media.thehoard.thirdparty.api.trakt.objects.basic.TraktSharing withFacebook(Boolean facebook) {
		this.facebook = facebook;
		return this;
	}

	@Override
	public Boolean getTwitter() {
		return twitter;
	}

	@Override
	public void setTwitter(Boolean twitter) {
		this.twitter = twitter;
	}

	@Override
	public media.thehoard.thirdparty.api.trakt.objects.basic.TraktSharing withTwitter(Boolean twitter) {
		this.twitter = twitter;
		return this;
	}

	@Override
	public Boolean getGoogle() {
		return google;
	}

	@Override
	public void setGoogle(Boolean google) {
		this.google = google;
	}

	@Override
	public media.thehoard.thirdparty.api.trakt.objects.basic.TraktSharing withGoogle(Boolean google) {
		this.google = google;
		return this;
	}

	@Override
	public Boolean getTumblr() {
		return tumblr;
	}

	@Override
	public void setTumblr(Boolean tumblr) {
		this.tumblr = tumblr;
	}

	@Override
	public media.thehoard.thirdparty.api.trakt.objects.basic.TraktSharing withTumblr(Boolean tumblr) {
		this.tumblr = tumblr;
		return this;
	}

	@Override
	public Boolean getMedium() {
		return medium;
	}

	@Override
	public void setMedium(Boolean medium) {
		this.medium = medium;
	}

	@Override
	public media.thehoard.thirdparty.api.trakt.objects.basic.TraktSharing withMedium(Boolean medium) {
		this.medium = medium;
		return this;
	}

	@Override
	public Boolean getSlack() {
		return slack;
	}

	@Override
	public void setSlack(Boolean slack) {
		this.slack = slack;
	}

	@Override
	public media.thehoard.thirdparty.api.trakt.objects.basic.TraktSharing withSlack(Boolean slack) {
		this.slack = slack;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktSharingImpl that = (TraktSharingImpl) o;

		return (facebook != null ? facebook.equals(that.facebook) : that.facebook == null) && (twitter != null ? twitter
				.equals(that.twitter) : that.twitter == null) && (google != null ? google.equals(that.google)
				: that.google == null) && (tumblr != null ? tumblr.equals(that.tumblr) : that.tumblr == null) && (
				medium != null ? medium.equals(that.medium) : that.medium == null) && (slack != null ? slack
				.equals(that.slack) : that.slack == null);
	}

	@Override
	public int hashCode() {
		int result = facebook != null ? facebook.hashCode() : 0;
		result = 31 * result + (twitter != null ? twitter.hashCode() : 0);
		result = 31 * result + (google != null ? google.hashCode() : 0);
		result = 31 * result + (tumblr != null ? tumblr.hashCode() : 0);
		result = 31 * result + (medium != null ? medium.hashCode() : 0);
		result = 31 * result + (slack != null ? slack.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktSharing{" + "facebook=" + facebook + ", twitter=" + twitter + ", google=" + google + ", tumblr=" + tumblr + ", medium=" + medium + ", slack=" + slack + '}';
	}
}
