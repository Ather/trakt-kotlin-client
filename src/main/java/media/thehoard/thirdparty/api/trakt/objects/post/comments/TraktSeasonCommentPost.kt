package media.thehoard.thirdparty.api.trakt.objects.post.comments

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl

interface TraktSeasonCommentPost : TraktCommentPost {
    var season: TraktSeasonImpl
}