package media.thehoard.thirdparty.api.trakt.exceptions

class TraktValidationException @JvmOverloads constructor(message: String = "Unprocessable Entity - validation errors") : TraktException(message)
