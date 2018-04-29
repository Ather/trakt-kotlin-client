package com.atherapp.thirdparty.api.trakt.objects.basic.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.enums.TraktMediaAudio
import com.atherapp.thirdparty.api.trakt.enums.TraktMediaAudioChannel
import com.atherapp.thirdparty.api.trakt.enums.TraktMediaResolution
import com.atherapp.thirdparty.api.trakt.enums.TraktMediaType
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktMetadata

data class TraktMetadataImpl(
        @SerializedName("media_type")
        override var mediaType: TraktMediaType = TraktMediaType.UNSPECIFIED,
        override var resolution: TraktMediaResolution = TraktMediaResolution.UNSPECIFIED,
        override var audio: TraktMediaAudio = TraktMediaAudio.UNSPECIFIED,
        @SerializedName("audio_channels")
        override var audioChannels: TraktMediaAudioChannel = TraktMediaAudioChannel.UNSPECIFIED,
        @SerializedName("3d")
        override var threeDimensional: Boolean? = null
) : TraktMetadata