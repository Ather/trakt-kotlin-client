package media.thehoard.thirdparty.api.trakt.requests.interfaces.base

import media.thehoard.thirdparty.api.trakt.requests.base.AuthorizationRequirement

internal interface IHasRequestAuthorization {
    val authorizationRequirement: AuthorizationRequirement
}
