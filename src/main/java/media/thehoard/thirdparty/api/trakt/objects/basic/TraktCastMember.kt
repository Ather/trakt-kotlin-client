package media.thehoard.thirdparty.api.trakt.objects.basic

import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPerson

interface TraktCastMember {
    var character: String

    var person: TraktPerson
}
