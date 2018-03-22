package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktNetwork

data class TraktNetworkImpl(override var network: String = "") : TraktNetwork
