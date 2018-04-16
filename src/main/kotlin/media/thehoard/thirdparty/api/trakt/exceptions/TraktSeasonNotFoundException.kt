package media.thehoard.thirdparty.api.trakt.exceptions

open class TraktSeasonNotFoundException(message: String, showId: String, var season: Int) : TraktShowNotFoundException(message, showId) {

    constructor(showId: String, season: Int) : this("Season Not Found - method exists, but no record found", showId, season)
}
