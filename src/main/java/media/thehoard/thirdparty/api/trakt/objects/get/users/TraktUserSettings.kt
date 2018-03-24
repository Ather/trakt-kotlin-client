package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktAccountSettingsImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktSharingTextImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl

interface TraktUserSettings {
    var user: TraktUserImpl

    var account: TraktAccountSettingsImpl

    var connections: TraktSharingImpl

    var sharingText: TraktSharingTextImpl

}
