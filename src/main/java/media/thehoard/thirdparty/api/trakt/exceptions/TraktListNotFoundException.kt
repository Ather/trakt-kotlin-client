package media.thehoard.thirdparty.api.trakt.exceptions

class TraktListNotFoundException(message: String, listId: String) : TraktObjectNotFoundException(message, listId) {

    constructor(listId: String) : this("List Not Found - method exists, but no record found", listId) {}
}
