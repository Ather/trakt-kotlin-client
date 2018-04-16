package media.thehoard.thirdparty.api.trakt.requests.interfaces

import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktCommonFilter

interface ISupportsFilter {
    var filter: TraktCommonFilter?
}
