package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCertifications

data class TraktCertificationsImpl(
        override var us: List<TraktCertificationImpl> = listOf()
) : TraktCertifications