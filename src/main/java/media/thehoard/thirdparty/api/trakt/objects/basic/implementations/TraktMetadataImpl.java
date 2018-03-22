package media.thehoard.thirdparty.api.trakt.objects.basic.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.enums.TraktMediaAudio;
import media.thehoard.thirdparty.api.trakt.enums.TraktMediaAudioChannel;
import media.thehoard.thirdparty.api.trakt.enums.TraktMediaResolution;
import media.thehoard.thirdparty.api.trakt.enums.TraktMediaType;
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktMetadata;

public class TraktMetadataImpl implements TraktMetadata {
	@SerializedName("media_type")
	private TraktMediaType mediaType;
	private TraktMediaResolution resolution;
	private TraktMediaAudio audio;
	@SerializedName("audio_channels")
	private TraktMediaAudioChannel audioChannels;
	@SerializedName("3d")
	private Boolean threeDimensional;

	@Override
	public TraktMediaType getMediaType() {
		return mediaType;
	}

	@Override
	public void setMediaType(TraktMediaType mediaType) {
		this.mediaType = mediaType;
	}

	@Override
	public TraktMediaResolution getResolution() {
		return resolution;
	}

	@Override
	public void setResolution(TraktMediaResolution resolution) {
		this.resolution = resolution;
	}

	@Override
	public TraktMediaAudio getAudio() {
		return audio;
	}

	@Override
	public void setAudio(TraktMediaAudio audio) {
		this.audio = audio;
	}

	@Override
	public TraktMediaAudioChannel getAudioChannels() {
		return audioChannels;
	}

	@Override
	public void setAudioChannels(TraktMediaAudioChannel audioChannels) {
		this.audioChannels = audioChannels;
	}

	@Override
	public Boolean getThreeDimensional() {
		return threeDimensional;
	}

	@Override
	public void setThreeDimensional(Boolean threeDimensional) {
		this.threeDimensional = threeDimensional;
	}
}
