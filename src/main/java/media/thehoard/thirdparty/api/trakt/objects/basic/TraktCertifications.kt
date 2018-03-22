package media.thehoard.thirdparty.api.trakt.objects.basic

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCertificationImpl

interface TraktCertifications {
    var us: List<TraktCertificationImpl>
}
