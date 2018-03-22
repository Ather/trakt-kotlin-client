package media.thehoard.thirdparty.api.trakt.objects.basic;

import media.thehoard.thirdparty.api.trakt.enums.TraktMediaAudio;
import media.thehoard.thirdparty.api.trakt.enums.TraktMediaAudioChannel;
import media.thehoard.thirdparty.api.trakt.enums.TraktMediaResolution;
import media.thehoard.thirdparty.api.trakt.enums.TraktMediaType;

public interface TraktMetadata {
	TraktMediaType getMediaType();

	void setMediaType(TraktMediaType mediaType);

	TraktMediaResolution getResolution();

	void setResolution(TraktMediaResolution resolution);

	TraktMediaAudio getAudio();

	void setAudio(TraktMediaAudio audio);

	TraktMediaAudioChannel getAudioChannels();

	void setAudioChannels(TraktMediaAudioChannel audioChannels);

	Boolean getThreeDimensional();

	void setThreeDimensional(Boolean threeDimensional);
}
