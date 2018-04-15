package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles

interface TraktScrobblePost {
    var progress: Float

    var appVersion: String?

    var appDate: String?
}