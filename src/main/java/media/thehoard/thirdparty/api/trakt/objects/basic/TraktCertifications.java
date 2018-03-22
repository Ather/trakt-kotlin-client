package media.thehoard.thirdparty.api.trakt.objects.basic;

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCertificationImpl;

import java.util.List;

public interface TraktCertifications {
	List<TraktCertificationImpl> getUs();

	void setUs(List<TraktCertificationImpl> us);
}
