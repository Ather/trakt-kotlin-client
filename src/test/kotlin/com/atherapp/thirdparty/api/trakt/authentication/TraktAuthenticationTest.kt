package com.atherapp.thirdparty.api.trakt.authentication

import com.atherapp.thirdparty.api.trakt.TraktClient
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.util.*
import kotlin.test.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class TraktAuthenticationTest {

    lateinit var client: TraktClient
    lateinit var authentication: TraktAuthentication

    @BeforeAll
    fun init() {
        client = TraktClient()
        authentication = client.authentication
    }

    @Test
    fun `test client`() {
        assertNotNull(client)
        assertNotNull(authentication.client)
    }

    @Test
    fun `test default construction`() {
        authentication.run {
            assertNull(oAuthAuthorizationCode)
            UUID.fromString(antiForgeryToken)
            assertNotNull(authorization)
            assertNotNull(device)
            assertNull(clientId)
            assertNull(clientSecret)
            assertEquals(redirectUri, "urn:ietf:wg:oauth:2.0:oob")
            assertFalse { isAuthorized }
        }
    }

    @Test
    suspend fun `test authorization checks`() {
        authentication.run {
            assertEquals(checkIfAuthorizationIsExpiredOrWasRevokedAsync(false).await(), true to null)
            assertFails { checkIfAuthorizationIsExpiredOrWasRevokedAsync(null, false) }
            assertFails { checkIfAccessTokenWasRevokedOrIsNotValidAsync("") }

        }
    }
}