package media.thehoard.thirdparty.api.trakt.requests.certifications

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCertificationImpl
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse

internal sealed class ACertificationsRequest : AGetRequestHasResponse<TraktCertificationImpl>() {
    override val uriPathParameters: Map<String, Any>? = mapOf()

    override fun validate() {}
}

internal class MovieCertificationsRequest : ACertificationsRequest() {
    override val uriTemplate: String
        get() = "certifications/movies"
}

internal class ShowCertificationsRequest : ACertificationsRequest() {
    override val uriTemplate: String
        get() = "certifications/shows"
}