package media.thehoard.thirdparty.api.trakt.requests.handler

import jdk.incubator.http.HttpClient
import jdk.incubator.http.HttpRequest
import media.thehoard.thirdparty.api.trakt.requests.base.RequestObjectType
import media.thehoard.thirdparty.api.trakt.utils.http.HttpMethod
import java.net.URI
import java.time.Duration

internal class ExtendedHttpRequestMessage(
        val method: HttpMethod,
        uri: String? = null
) : HttpRequest.Builder() {
    private val httpRequestBuilder: HttpRequest.Builder = HttpRequest.newBuilder(URI.create(uri)).method(method.toString(), null)

    var objectId: String = ""

    var seasonNumber: Int? = null

    var episodeNumber: Int? = null

    var url: String = ""

    var requestObjectType: RequestObjectType? = null

    var requestBodyJson: String = ""

    fun body(body: HttpRequest.BodyProcessor?): HttpRequest.Builder = httpRequestBuilder.method(method.toString(), body)

    override fun DELETE(body: HttpRequest.BodyProcessor?): HttpRequest.Builder = httpRequestBuilder.DELETE(body)

    override fun uri(uri: URI?): HttpRequest.Builder = httpRequestBuilder.uri(uri)

    override fun timeout(duration: Duration?): HttpRequest.Builder = httpRequestBuilder.timeout(duration)

    override fun version(version: HttpClient.Version?): HttpRequest.Builder = httpRequestBuilder.version(version)

    override fun GET(): HttpRequest.Builder = httpRequestBuilder.GET()

    override fun method(method: String?, body: HttpRequest.BodyProcessor?): HttpRequest.Builder = httpRequestBuilder.method(method, body)

    override fun POST(body: HttpRequest.BodyProcessor?): HttpRequest.Builder = httpRequestBuilder.POST(body)

    override fun copy(): HttpRequest.Builder = httpRequestBuilder.copy()

    override fun expectContinue(enable: Boolean): HttpRequest.Builder = httpRequestBuilder.expectContinue(enable)

    override fun build(): HttpRequest = httpRequestBuilder.build()

    override fun header(name: String?, value: String?): HttpRequest.Builder = httpRequestBuilder.header(name, value)

    override fun setHeader(name: String?, value: String?): HttpRequest.Builder = httpRequestBuilder.setHeader(name, value)

    override fun PUT(body: HttpRequest.BodyProcessor?): HttpRequest.Builder = httpRequestBuilder.PUT(body)

    override fun headers(vararg headers: String?): HttpRequest.Builder = httpRequestBuilder.headers(*headers)
}
