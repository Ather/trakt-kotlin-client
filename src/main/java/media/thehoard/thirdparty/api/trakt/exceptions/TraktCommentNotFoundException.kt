package media.thehoard.thirdparty.api.trakt.exceptions

class TraktCommentNotFoundException(message: String, commentId: String) : TraktObjectNotFoundException(message, commentId) {

    constructor(commentId: String) : this("Comment Not Found - method exists, but no record found", commentId) {}
}
