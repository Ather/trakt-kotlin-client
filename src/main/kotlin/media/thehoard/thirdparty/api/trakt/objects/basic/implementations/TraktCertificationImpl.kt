package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCertification

data class TraktCertificationImpl(
        override var name: String = "",
        override var slug: String = "",
        override var description: String = ""
) : TraktCertification
