package media.thehoard.thirdparty.api.trakt.objects.basic.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktImage;

public class TraktImageImpl implements TraktImage {
	private String full;

	@Override
	public String getFull() {
		return full;
	}

	@Override
	public void setFull(String full) {
		this.full = full;
	}
}
