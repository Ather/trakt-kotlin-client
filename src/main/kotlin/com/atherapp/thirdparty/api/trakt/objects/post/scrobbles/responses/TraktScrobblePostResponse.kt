package com.atherapp.thirdparty.api.trakt.objects.post.scrobbles.responses

import com.atherapp.thirdparty.api.trakt.enums.TraktScrobbleActionType
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing

interface TraktScrobblePostResponse {
    var id: Long

    var action: TraktScrobbleActionType

    var progress: Float?

    var sharing: TraktSharing
}