package com.atherapp.thirdparty.api.trakt.modules

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.core.Constants
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktDevice
import com.atherapp.thirdparty.api.trakt.objects.authentication.implementations.TraktAuthorizationImpl
import com.atherapp.thirdparty.api.trakt.objects.authentication.implementations.TraktDeviceImpl
import java.util.*

class TraktAuthenticationModule internal constructor(override val client: TraktClient) : TraktModule {

    private var _authorization: TraktAuthorization? = null
    private var _device: TraktDevice? = null

    var authorization: TraktAuthorization
        get() {
            if (_authorization == null)
                _authorization = TraktAuthorizationImpl()
            return _authorization!!
        }
        set(value) {
            _authorization = value
        }
    var device: TraktDevice
        get() {
            if (_device == null)
                _device = TraktDeviceImpl()
            return _device!!
        }
        set(value) {
            _device = value
        }

    val antiForgeryToken = UUID.randomUUID().toString()

    var clientId: String? = null

    var clientSecret: String? = null

    var redirectUri: String = Constants.DEFAULT_REDIRECT_URI

    val isAuthorized: Boolean
        get() = _authorization?.isExpired == false
}