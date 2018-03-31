package media.thehoard.thirdparty.api.trakt.requests.interfaces.base

interface IHasRequestBody<TRequestBodyType> {
    var requestBody: TRequestBodyType
}
