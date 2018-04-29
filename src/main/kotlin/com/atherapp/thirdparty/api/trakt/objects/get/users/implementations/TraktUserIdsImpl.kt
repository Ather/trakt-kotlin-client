package com.atherapp.thirdparty.api.trakt.objects.get.users.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktDefaultIds
import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktUserIds

data class TraktUserIdsImpl(
        override var slug: String = ""
) : TraktUserIds {

    override fun hasAnyId(): Boolean {
        return getBestId().isNotBlank()
    }

    override fun getBestId(): String {
        return when {
            isValid(slug) -> slug
            else -> ""
        }
    }

    override fun hasIdMatch(ids: TraktDefaultIds): Boolean {
        return if (ids is TraktUserIdsImpl) {
            val (slug1) = ids
            return (isValid(slug) && isValid(slug1) && slug == slug1)
        } else
            false
    }
}
