package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktError

data class TraktErrorImpl(
        override var error: String = "",
        override var description: String = ""
) : TraktError
