package media.thehoard.thirdparty.api.trakt.requests.interfaces.base

import media.thehoard.thirdparty.api.trakt.requests.base.AuthorizationRequirement

interface IHasRequestAuthorization {
    val authorizationRequirement: AuthorizationRequirement
}
