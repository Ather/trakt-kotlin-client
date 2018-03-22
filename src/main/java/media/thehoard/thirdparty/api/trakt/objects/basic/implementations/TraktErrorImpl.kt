package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktError

class TraktErrorImpl : TraktError {
    override var error: String = ""
    override var description: String = ""
}
