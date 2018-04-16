package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktSharingText

data class TraktSharingTextImpl(
        override var watching: String = "",
        override var watched: String = ""
) : TraktSharingText
