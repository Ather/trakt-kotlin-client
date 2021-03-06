package com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktShowIds
import com.atherapp.thirdparty.api.trakt.enums.TraktShowStatus
import com.atherapp.thirdparty.api.trakt.extensions.isNotNegative
import com.atherapp.thirdparty.api.trakt.extensions.isValidYear
import com.atherapp.thirdparty.api.trakt.extensions.validate
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShowAirs
import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime

data class TraktShowImpl(
        override var title: String = "",
        override var year: Int = -1,
        override var ids: TraktShowIds = TraktShowIds(),
        override var overview: String? = null,
        @SerializedName("first_aired")
        override var firstAired: ZonedDateTime? = null,
        override var airs: TraktShowAirs? = null,
        override var runtime: Int? = null,
        override var certification: String? = null,
        override var network: String? = null,
        override var country: String? = null,
        @SerializedName("updated_at")
        override var updatedAt: ZonedDateTime? = null,
        override var trailer: String? = null,
        override var homepage: String? = null,
        override var status: TraktShowStatus? = null,
        override var rating: Float? = null,
        override var votes: Int? = null,
        @SerializedName("comment_count")
        override var commentCount: Int? = null,
        override var language: String? = null,
        @SerializedName("available_translations")
        override var availableTranslations: List<String>? = null,
        override var genres: List<String>? = null,
        @SerializedName("aired_episodes")
        override var airedEpisodes: Int? = null
) : TraktShow {
    override fun validateWithEpisode(episode: TraktEpisode?) {
        if (episode != null) {
            episode.season.validate("episode season number", ::isNotNegative)
            episode.number.validate("episode number", ::isNotNegative)
            title.validate("show title", String::isNotBlank)
        } else {
            validate("show")
        }
    }

    override fun validate(variableName: String) {
        title.validate("show title", String::isNotBlank)
        year.validate("show year", ::isValidYear)
        ids.validate("show ids")
    }
}