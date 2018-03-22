package media.thehoard.thirdparty.api.trakt.objects.basic

import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl

interface TraktCrewMember {
    var job: String

    var person: TraktPersonImpl
}
