package media.thehoard.thirdparty.api.trakt.objects.basic

interface TraktRating {
    var rating: Float?

    var votes: Int?

    var distribution: Map<String, Int>
}
