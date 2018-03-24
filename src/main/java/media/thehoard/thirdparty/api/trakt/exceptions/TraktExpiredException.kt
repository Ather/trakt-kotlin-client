package media.thehoard.thirdparty.api.trakt.exceptions

class TraktExpiredException @JvmOverloads constructor(message: String = "Expired - the tokens have expired, restart the process") : TraktException(message)
