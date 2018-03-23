package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowAirs

data class TraktShowAirsImpl(override var day: String = "",
                             override var time: String = "",
                             override var timezone: String = "") : TraktShowAirs
