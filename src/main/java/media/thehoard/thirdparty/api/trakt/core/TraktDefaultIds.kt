package media.thehoard.thirdparty.api.trakt.core

import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IValidatable

interface TraktDefaultIds: IValidatable {
    fun getBestId(): String
    fun hasAnyId(): Boolean
    fun hasIdMatch(ids: TraktDefaultIds): Boolean

    fun isValid(stringId: String?): Boolean {
        return !stringId.isNullOrBlank()
    }

    fun isValid(intId: Int?): Boolean {
        return intId != null && intId > 0
    }

    infix fun like(ids: TraktDefaultIds): Boolean = hasIdMatch(ids)

    override fun validate(variableName: String) = hasAnyId().validate(variableName)
}
