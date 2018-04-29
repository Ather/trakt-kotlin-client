package com.atherapp.thirdparty.api.trakt.requests.people

import com.atherapp.thirdparty.api.trakt.objects.get.people.TraktPerson
import com.atherapp.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCredits
import com.atherapp.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCredits
import com.atherapp.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import com.atherapp.thirdparty.api.trakt.requests.base.RequestObjectType
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IHasId
import com.atherapp.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import kotlin.reflect.KClass

internal sealed class APersonRequest<TResponseContentType : Any>(
        override val uriTemplate: String,
        responseContentClass: KClass<TResponseContentType>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass), IHasId, ISupportsExtendedInfo {
    override val requestObjectType: RequestObjectType = RequestObjectType.People

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo.toString()
        }

    override fun validate(variableName: String) {}
}

internal class PersonMovieCreditsRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo?
) : APersonRequest<TraktPersonMovieCredits>(
        "people/{id}/movies{?extended}",
        TraktPersonMovieCredits::class
)

internal class PersonShowCreditsRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo?
) : APersonRequest<TraktPersonShowCredits>(
        "people/{id}/shows{?extended}",
        TraktPersonShowCredits::class
)

internal class PersonSummaryRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo?
) : APersonRequest<TraktPerson>(
        "people/{id}{?extended}",
        TraktPerson::class
)