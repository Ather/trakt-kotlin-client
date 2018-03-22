package media.thehoard.thirdparty.api.trakt.objects.post.checkins

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl

interface TraktCheckinPost {
    var sharing: TraktSharingImpl

    var message: String

    var appVersion: String

    var appDate: String

    var foursquareVenueId: String

    var foursquareVenueName: String
}
