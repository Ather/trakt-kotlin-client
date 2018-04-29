package com.atherapp.thirdparty.api.trakt.responses

import com.atherapp.thirdparty.api.trakt.responses.interfaces.ITraktNoContentResponse

open class TraktNoContentResponse : ITraktNoContentResponse {
    override var isSuccess: Boolean = false

    override var exception: Exception? = null

    override fun equals(other: Any?): Boolean {
        if (other is TraktNoContentResponse)
            return isSuccess == other.isSuccess && exception == other.exception

        return false
    }

    override fun hashCode(): Int {
        var result = isSuccess.hashCode()
        result = 31 * result + (exception?.hashCode() ?: 0)
        return result
    }
}
