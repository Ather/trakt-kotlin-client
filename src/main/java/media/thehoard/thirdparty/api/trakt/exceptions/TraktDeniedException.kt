package media.thehoard.thirdparty.api.trakt.exceptions

class TraktDeniedException @JvmOverloads constructor(message: String = "Denied - user explicitly denied this code") : TraktException(message)
