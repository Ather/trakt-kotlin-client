package media.thehoard.thirdparty.api.trakt.core

interface TraktDefaultIds {
    fun getBestId(): String
    fun hasAnyId(): Boolean
    fun hasIdMatch(ids: TraktDefaultIds): Boolean

    fun isValid(stringId: String?): Boolean {
        return !stringId.isNullOrEmpty()
    }

    fun isValid(intId: Int?): Boolean {
        return intId != null && intId > 0
    }
}
