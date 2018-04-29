package com.atherapp.thirdparty.api.trakt.objects.post.responses.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.people.TraktPersonIds
import com.atherapp.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonIdsImpl
import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundPerson

data class TraktPostResponseNotFoundPersonImpl(
        override var ids: TraktPersonIds = TraktPersonIdsImpl()
) : TraktPostResponseNotFoundPerson
