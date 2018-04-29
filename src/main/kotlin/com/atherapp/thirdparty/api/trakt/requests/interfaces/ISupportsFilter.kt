package com.atherapp.thirdparty.api.trakt.requests.interfaces

import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktCommonFilter

interface ISupportsFilter {
    var filter: TraktCommonFilter?
}
