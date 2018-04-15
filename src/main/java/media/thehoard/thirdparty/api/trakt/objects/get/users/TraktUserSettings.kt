package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktSharing

interface TraktUserSettings {
    var user: TraktUser

    var account: TraktAccountSettings

    var connections: TraktSharing

    var sharingText: TraktSharingText

}
