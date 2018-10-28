package com.atherapp.thirdparty.api.trakt

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

internal class TraktClientTest {
    companion object {
        const val VALID_CLIENT_ID = "CLIENT_ID"
        const val VALID_CLIENT_SECRET = "CLIENT_SECRET"

        const val INVALID_CLIENT_ID = "CLIENT ID"
        const val INVALID_CLIENT_SECRET = "CLIENT SECRET"
    }

    @Test
    fun `test default construction`() {
        TraktClient().run {
            assertNotNull(configuration)
            assertNotNull(authentication)
            //assertNotNull(oAuth)
            //assertNotNull(deviceAuth)
            assertNotNull(calendars)
            assertNotNull(checkin)
            assertNotNull(certifications)
            assertNotNull(comments)
            assertNotNull(genres)
            assertNotNull(movies)
            assertNotNull(networks)
            assertNotNull(people)
            assertNotNull(recommendations)
            assertNotNull(scrobble)
            assertNotNull(search)
            assertNotNull(shows)
            assertNotNull(seasons)
            assertNotNull(episodes)
            assertNotNull(sync)
            assertNotNull(users)

            assertNull(clientId)
            assertNull(clientSecret)

            assertNotNull(authorization)

            assertFalse { isValidForUseWithoutAuthorization }
            assertFalse { isValidForUseWithAuthorization }
            assertFalse { isValidForAuthenticationProcess }
        }
    }

    @Test
    fun `test invalid client`() {
        TraktClient(
                clientId = INVALID_CLIENT_ID,
                clientSecret = INVALID_CLIENT_SECRET
        ).run {
            assertFalse { isValidForUseWithoutAuthorization }
            assertFalse { isValidForUseWithAuthorization }
            assertFalse { isValidForAuthenticationProcess }
        }
    }

    /**
     * Test a valid client ID with an invalid secret
     */
    @Test
    fun `test semivalid client`() {
        TraktClient(
                clientId = VALID_CLIENT_ID,
                clientSecret = INVALID_CLIENT_SECRET
        ).run {
            assertTrue { isValidForUseWithoutAuthorization }
            assertFalse { isValidForUseWithAuthorization }
            assertFalse { isValidForAuthenticationProcess }
        }
    }

    @Test
    fun `test valid client`() {
        TraktClient(
                clientId = VALID_CLIENT_ID,
                clientSecret = VALID_CLIENT_SECRET
        ).run {
            assertTrue { isValidForUseWithoutAuthorization }
            assertFalse { isValidForUseWithAuthorization }
            assertTrue { isValidForAuthenticationProcess }
        }
    }
}