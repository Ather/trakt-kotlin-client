package com.atherapp.thirdparty.api.trakt.exceptions

class TraktEpisodeNotFoundException(message: String, showId: String, season: Int, var episode: Int) : TraktSeasonNotFoundException(message, showId, season) {

    constructor(showId: String, season: Int, episode: Int) : this("Episode Not Found - method exists, but no record found", showId, season, episode)
}
