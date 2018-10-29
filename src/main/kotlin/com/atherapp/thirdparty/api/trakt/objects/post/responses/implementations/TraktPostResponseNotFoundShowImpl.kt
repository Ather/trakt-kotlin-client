package com.atherapp.thirdparty.api.trakt.objects.post.responses.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktShowIds
import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundShow

data class TraktPostResponseNotFoundShowImpl(
        override var ids: TraktShowIds = TraktShowIds()
) : TraktPostResponseNotFoundShow
