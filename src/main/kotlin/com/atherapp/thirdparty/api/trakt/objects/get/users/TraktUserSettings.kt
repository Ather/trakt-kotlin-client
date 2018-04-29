package com.atherapp.thirdparty.api.trakt.objects.get.users

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing

interface TraktUserSettings {
    var user: TraktUser

    var account: TraktAccountSettings

    var connections: TraktSharing

    var sharingText: TraktSharingText

}
