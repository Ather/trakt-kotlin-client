package com.atherapp.thirdparty.api.trakt.modules

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.get.people.TraktPerson
import com.atherapp.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCredits
import com.atherapp.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCredits
import com.atherapp.thirdparty.api.trakt.requests.handler.RequestHandler
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import com.atherapp.thirdparty.api.trakt.requests.people.PersonMovieCreditsRequest
import com.atherapp.thirdparty.api.trakt.requests.people.PersonShowCreditsRequest
import com.atherapp.thirdparty.api.trakt.requests.people.PersonSummaryRequest
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class TraktPeopleModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getPersonAsync(
            personIdOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktPerson>> {
        return RequestHandler(client).executeSingleItemRequestAsync(PersonSummaryRequest(personIdOrSlug, extendedInfo), requestAuthorization)
    }

    fun getMultiplePersonsAsync(
            personsQueryParams: TraktMultipleObjectsQueryParams,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<List<TraktResponse<TraktPerson>>> {
        if (personsQueryParams.isEmpty())
            return CompletableDeferred(listOf())

        var i = 0
        val tasks = Array(personsQueryParams.size) {
            val queryParam = personsQueryParams[i++]
            return@Array getPersonAsync(queryParam.idOrSlug, queryParam.extendedInfo, requestAuthorization)
        }

        return GlobalScope.async { tasks.map { it.await() } }
    }

    fun getPersonMovieCreditsAsync(
            personIdOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktPersonMovieCredits>> {
        return RequestHandler(client).executeSingleItemRequestAsync(PersonMovieCreditsRequest(personIdOrSlug, extendedInfo), requestAuthorization)
    }

    fun getPersonShowCreditsAsync(
            personIdOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktPersonShowCredits>> {
        return RequestHandler(client).executeSingleItemRequestAsync(PersonShowCreditsRequest(personIdOrSlug, extendedInfo), requestAuthorization)
    }
}
