package media.thehoard.thirdparty.api.trakt.requests.interfaces

import media.thehoard.thirdparty.api.trakt.utils.Json

interface IRequestBody : IValidatable {
    fun toJson(): String = Json.serialize(this)
}