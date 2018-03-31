package media.thehoard.thirdparty.api.trakt.requests.interfaces.base

import media.thehoard.thirdparty.api.trakt.utils.http.HttpMethod

interface IHttpRequest {
    val method: HttpMethod
}
