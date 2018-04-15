package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktScrobblePost : IRequestBody {
    var progress: Float

    var appVersion: String?

    var appDate: String?
}