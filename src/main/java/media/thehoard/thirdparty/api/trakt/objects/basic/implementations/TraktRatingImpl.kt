package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktRating

data class TraktRatingImpl(override var rating: Float? = null,
                           override var votes: Int? = null,
                           override var distribution: Map<String, Int> = mapOf()) : TraktRating
