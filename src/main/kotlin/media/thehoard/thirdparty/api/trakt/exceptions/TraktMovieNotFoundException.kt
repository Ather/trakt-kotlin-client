package media.thehoard.thirdparty.api.trakt.exceptions

class TraktMovieNotFoundException(message: String, movieId: String) : TraktObjectNotFoundException(message, movieId) {

    constructor(movieId: String) : this("Movie Not Found - method exists, but no record found", movieId)
}
