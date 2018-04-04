package media.thehoard.thirdparty.api.trakt

import media.thehoard.thirdparty.api.trakt.authentication.TraktAuthentication
import media.thehoard.thirdparty.api.trakt.authentication.TraktDeviceAuth
import media.thehoard.thirdparty.api.trakt.authentication.TraktOAuth
import media.thehoard.thirdparty.api.trakt.core.TraktConfiguration
import media.thehoard.thirdparty.api.trakt.extensions.containsSpace
import media.thehoard.thirdparty.api.trakt.modules.*

import java.util.concurrent.Executors

class TraktClient internal constructor() {
    val configuration: TraktConfiguration = TraktConfiguration()

    val authentication: TraktAuthentication = TraktAuthentication(this)

    val oAuth: TraktOAuth = TraktOAuth(this)

    val deviceAuth: TraktDeviceAuth = TraktDeviceAuth(this)

    val calendars: TraktCalendarsModule = TraktCalendarsModule(this)

    val checkin: TraktCheckinModule = TraktCheckinModule(this)

    val certifications: TraktCertificationsModule = TraktCertificationsModule(this)

    val comments: TraktCommentsModule = TraktCommentsModule(this)

    val genres: TraktGenresModule = TraktGenresModule(this)

    val movies: TraktMoviesModule = TraktMoviesModule(this)

    val networks: TraktNetworksModule = TraktNetworksModule(this)

    val people: TraktPeopleModule = TraktPeopleModule(this)

    val recommendations: TraktRecommendationsModule = TraktRecommendationsModule(this)

    val scrobble: TraktScrobbleModule = TraktScrobbleModule(this)

    val search: TraktSearchModule = TraktSearchModule(this)

    val shows: TraktShowsModule = TraktShowsModule(this)

    val seasons: TraktSeasonsModule = TraktSeasonsModule(this)

    val episodes: TraktEpisodesModule = TraktEpisodesModule(this)

    val sync: TraktSyncModule = TraktSyncModule(this)

    val users: TraktUsersModule = TraktUsersModule(this)

    var clientId: String?
        get() = authentication.clientId
        set(value) {
            authentication.clientId = value
        }


    var clientSecret: String?
        get() = authentication.clientSecret
        set(value) {
            authentication.clientSecret = value
        }

    val isValidForUseWithoutAuthorization: Boolean?
        get() = clientId.isNullOrBlank() && !clientId!!.containsSpace()

    val isValidForUseWithAuthorization: Boolean?
        get() = isValidForUseWithoutAuthorization!! && authentication.isAuthorized

    val isValidForAuthenticationProcess: Boolean?
        get() = isValidForUseWithoutAuthorization!! && !clientSecret.isNullOrBlank() && !clientSecret!!.containsSpace()

    constructor(clientId: String) : this() {
        this.clientId = clientId
    }

    constructor(clientId: String, clientSecret: String) : this(clientId) {
        this.clientSecret = clientSecret
    }

    companion object {
        internal val MAIN_THREAD_POOL = Executors.newCachedThreadPool()
    }
}
