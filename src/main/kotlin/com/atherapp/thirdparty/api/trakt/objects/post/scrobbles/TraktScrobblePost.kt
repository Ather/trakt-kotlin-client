package com.atherapp.thirdparty.api.trakt.objects.post.scrobbles

import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktScrobblePost : IRequestBody {
    var progress: Float

    var appVersion: String?

    var appDate: String?
}