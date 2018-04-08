package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient

class TraktSearchModule internal constructor(override val client: TraktClient) : TraktModule
