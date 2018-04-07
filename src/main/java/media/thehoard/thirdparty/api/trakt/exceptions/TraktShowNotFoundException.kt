package media.thehoard.thirdparty.api.trakt.exceptions

open class TraktShowNotFoundException(message: String, showId: String) : TraktObjectNotFoundException(message, showId) {

    constructor(showId: String) : this("Show Not Found - method exists, but no record found", showId)
}
