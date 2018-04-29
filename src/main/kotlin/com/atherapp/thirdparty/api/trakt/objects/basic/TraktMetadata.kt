package com.atherapp.thirdparty.api.trakt.objects.basic

import com.atherapp.thirdparty.api.trakt.enums.TraktMediaAudio
import com.atherapp.thirdparty.api.trakt.enums.TraktMediaAudioChannel
import com.atherapp.thirdparty.api.trakt.enums.TraktMediaResolution
import com.atherapp.thirdparty.api.trakt.enums.TraktMediaType

interface TraktMetadata {
    var mediaType: TraktMediaType

    var resolution: TraktMediaResolution

    var audio: TraktMediaAudio

    var audioChannels: TraktMediaAudioChannel

    var threeDimensional: Boolean?
}
