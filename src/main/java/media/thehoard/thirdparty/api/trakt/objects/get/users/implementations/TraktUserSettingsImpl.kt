package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserSettings

data class TraktUserSettingsImpl(
        override var user: TraktUserImpl = TraktUserImpl(),
        override var account: TraktAccountSettingsImpl = TraktAccountSettingsImpl(),
        override var connections: TraktSharingImpl = TraktSharingImpl(),
        @SerializedName("sharing_text") override var sharingText: TraktSharingTextImpl = TraktSharingTextImpl()
) : TraktUserSettings
