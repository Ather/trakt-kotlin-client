package com.atherapp.thirdparty.api.trakt.objects.get.users.lists

import com.atherapp.thirdparty.api.trakt.core.TraktDefaultIds

interface TraktListIds : TraktDefaultIds {
    var trakt: Int

    var slug: String

}
