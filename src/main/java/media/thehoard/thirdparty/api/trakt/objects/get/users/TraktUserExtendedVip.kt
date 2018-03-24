package media.thehoard.thirdparty.api.trakt.objects.get.users

interface TraktUserExtendedVip : TraktUser {
    var vipOg: Boolean?

    var vipYears: Int?

}
