package com.atherapp.thirdparty.api.trakt.objects.get.users.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktSharingText

data class TraktSharingTextImpl(
        override var watching: String = "",
        override var watched: String = ""
) : TraktSharingText
