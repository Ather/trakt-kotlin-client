package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient

class TraktShowsModule internal constructor(override val client: TraktClient) : TraktModule
