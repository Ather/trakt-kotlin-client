package com.atherapp.thirdparty.api.trakt.objects.get.users.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing
import com.atherapp.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktAccountSettings
import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktSharingText
import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktUser
import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktUserSettings

data class TraktUserSettingsImpl(
        override var user: TraktUser = TraktUserImpl(),
        override var account: TraktAccountSettings = TraktAccountSettingsImpl(),
        override var connections: TraktSharing = TraktSharingImpl(),
        @SerializedName("sharing_text") override var sharingText: TraktSharingText = TraktSharingTextImpl()
) : TraktUserSettings
