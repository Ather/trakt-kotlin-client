package media.thehoard.thirdparty.api.trakt.exceptions

class TraktDeniedException(message: String = "Denied - user explicitly denied this code") : TraktException(message)
