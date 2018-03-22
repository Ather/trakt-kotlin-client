package media.thehoard.thirdparty.api.trakt.objects.basic

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCrewMemberImpl

interface TraktCrew {
    var production: List<TraktCrewMemberImpl>

    var art: List<TraktCrewMemberImpl>

    var crew: List<TraktCrewMemberImpl>

    var costumeAndMakeup: List<TraktCrewMemberImpl>

    var directing: List<TraktCrewMemberImpl>

    var writing: List<TraktCrewMemberImpl>

    var sound: List<TraktCrewMemberImpl>

    var camera: List<TraktCrewMemberImpl>

    var lighting: List<TraktCrewMemberImpl>

    var visualEffects: List<TraktCrewMemberImpl>

    var editing: List<TraktCrewMemberImpl>
}
