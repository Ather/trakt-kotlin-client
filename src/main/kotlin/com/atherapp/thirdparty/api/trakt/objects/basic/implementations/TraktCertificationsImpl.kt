package com.atherapp.thirdparty.api.trakt.objects.basic.implementations

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktCertification
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktCertifications

data class TraktCertificationsImpl(
        override var us: List<TraktCertification> = listOf()
) : TraktCertifications