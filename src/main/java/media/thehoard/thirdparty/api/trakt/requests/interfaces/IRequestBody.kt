package media.thehoard.thirdparty.api.trakt.requests.interfaces

interface IRequestBody : IValidatable {
    fun toJson(): String
}