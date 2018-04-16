package media.thehoard.thirdparty.api.trakt.objects.post.comments

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason

interface TraktSeasonCommentPost : TraktCommentPost {
    var season: TraktSeason
}