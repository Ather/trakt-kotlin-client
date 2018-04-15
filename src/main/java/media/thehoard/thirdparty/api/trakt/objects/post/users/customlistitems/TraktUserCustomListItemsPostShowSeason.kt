package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems

interface TraktUserCustomListItemsPostShowSeason {
    var number: Int
    var episodes: MutableList<TraktUserCustomListItemsPostShowEpisode>
}