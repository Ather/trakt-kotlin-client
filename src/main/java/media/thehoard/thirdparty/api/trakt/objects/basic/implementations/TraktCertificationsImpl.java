package media.thehoard.thirdparty.api.trakt.objects.basic.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCertifications;

import java.util.List;

public class TraktCertificationsImpl implements TraktCertifications {
	private List<TraktCertificationImpl> us;

	@Override
	public List<TraktCertificationImpl> getUs() {
		return us;
	}

	@Override
	public void setUs(List<TraktCertificationImpl> us) {
		this.us = us;
	}
}
