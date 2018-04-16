package media.thehoard.thirdparty.api.trakt.objects.basic

import media.thehoard.thirdparty.api.trakt.enums.TraktMediaAudio
import media.thehoard.thirdparty.api.trakt.enums.TraktMediaAudioChannel
import media.thehoard.thirdparty.api.trakt.enums.TraktMediaResolution
import media.thehoard.thirdparty.api.trakt.enums.TraktMediaType

interface TraktMetadata {
    var mediaType: TraktMediaType

    var resolution: TraktMediaResolution

    var audio: TraktMediaAudio

    var audioChannels: TraktMediaAudioChannel

    var threeDimensional: Boolean?
}
