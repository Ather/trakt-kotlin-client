package com.atherapp.thirdparty.api.trakt.objects.get.users.implementations

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktImage
import com.atherapp.thirdparty.api.trakt.objects.basic.implementations.TraktImageImpl
import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktUserImages

data class TraktUserImagesImpl(
        override var avatar: TraktImage = TraktImageImpl()
) : TraktUserImages
