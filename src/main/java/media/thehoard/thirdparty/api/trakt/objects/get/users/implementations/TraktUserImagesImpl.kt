package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktImage
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktImageImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserImages

data class TraktUserImagesImpl(
        override var avatar: TraktImage = TraktImageImpl()
) : TraktUserImages
