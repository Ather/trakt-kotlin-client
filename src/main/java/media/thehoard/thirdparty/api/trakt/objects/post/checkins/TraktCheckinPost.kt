package media.thehoard.thirdparty.api.trakt.objects.post.checkins

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktCheckinPost : IRequestBody {
    var sharing: TraktSharingImpl?

    var message: String?

    var appVersion: String?

    var appDate: String?

    var foursquareVenueId: String?

    var foursquareVenueName: String?
}
