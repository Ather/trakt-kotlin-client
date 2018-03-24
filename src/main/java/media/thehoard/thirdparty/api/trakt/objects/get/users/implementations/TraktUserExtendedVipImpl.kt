package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserExtendedVip

data class TraktUserExtendedVipImpl(
        override var username: String = "",
        @SerializedName("private") override var private: Boolean? = null,
        override var name: String = "",
        @SerializedName("vip") override var vip: Boolean? = null,
        @SerializedName("vip_ep") override var vipEp: Boolean? = null,
        override var ids: TraktUserIdsImpl = TraktUserIdsImpl(),
        @SerializedName("vip_og") override var vipOg: Boolean? = null,
        @SerializedName("vip_years") override var vipYears: Int? = null
) : TraktUserExtendedVip
