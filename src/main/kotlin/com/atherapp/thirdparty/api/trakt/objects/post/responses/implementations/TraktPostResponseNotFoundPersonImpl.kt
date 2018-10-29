package com.atherapp.thirdparty.api.trakt.objects.post.responses.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktPersonIds
import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundPerson

data class TraktPostResponseNotFoundPersonImpl(
        override var ids: TraktPersonIds = TraktPersonIds()
) : TraktPostResponseNotFoundPerson
