package media.thehoard.thirdparty.api.trakt.objects.get.people

import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonIdsImpl

interface TraktPerson {
    var name: String

    var ids: TraktPersonIdsImpl

}
