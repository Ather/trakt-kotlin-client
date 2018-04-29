package com.atherapp.thirdparty.api.trakt.objects.basic.implementations

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing

data class TraktSharingImpl(
        override var facebook: Boolean? = null,
        override var twitter: Boolean? = null,
        override var google: Boolean? = null,
        override var tumblr: Boolean? = null,
        override var medium: Boolean? = null,
        override var slack: Boolean? = null
) : TraktSharing
