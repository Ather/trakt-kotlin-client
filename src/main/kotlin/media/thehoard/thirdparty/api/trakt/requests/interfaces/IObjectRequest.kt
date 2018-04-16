package media.thehoard.thirdparty.api.trakt.requests.interfaces

import media.thehoard.thirdparty.api.trakt.requests.base.RequestObjectType

internal interface IObjectRequest {
    val requestObjectType: RequestObjectType
}
