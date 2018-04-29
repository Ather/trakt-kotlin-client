package com.atherapp.thirdparty.api.trakt.objects.post.responses.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShowIds
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundShow

data class TraktPostResponseNotFoundShowImpl(
        override var ids: TraktShowIds = TraktShowIdsImpl()
) : TraktPostResponseNotFoundShow
