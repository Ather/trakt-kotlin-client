package media.thehoard.thirdparty.api.trakt.requests.certifications

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCertifications
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse

internal sealed class ACertificationsRequest(override val uriTemplate: String) : AGetRequestHasResponse<TraktCertifications>(TraktCertifications::class) {
    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()

    override fun validate(variableName: String) {}
}

internal class MovieCertificationsRequest : ACertificationsRequest("certifications/movies")

internal class ShowCertificationsRequest : ACertificationsRequest("certifications/shows")