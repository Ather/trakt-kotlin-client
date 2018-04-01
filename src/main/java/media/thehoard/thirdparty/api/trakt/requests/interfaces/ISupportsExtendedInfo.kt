package media.thehoard.thirdparty.api.trakt.requests.interfaces

import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo

interface ISupportsExtendedInfo {
    var extendedInfo: TraktExtendedInfo?
}
