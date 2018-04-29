package com.atherapp.thirdparty.api.trakt.requests.interfaces

import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo

interface ISupportsExtendedInfo {
    var extendedInfo: TraktExtendedInfo?
}
