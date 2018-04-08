package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient

class TraktMoviesModule internal constructor(override val client: TraktClient) : TraktModule
