package media.thehoard.thirdparty.api.trakt.objects.basic

interface TraktCrew {
    var production: List<TraktCrewMember>

    var art: List<TraktCrewMember>

    var crew: List<TraktCrewMember>

    var costumeAndMakeup: List<TraktCrewMember>

    var directing: List<TraktCrewMember>

    var writing: List<TraktCrewMember>

    var sound: List<TraktCrewMember>

    var camera: List<TraktCrewMember>

    var lighting: List<TraktCrewMember>

    var visualEffects: List<TraktCrewMember>

    var editing: List<TraktCrewMember>
}
