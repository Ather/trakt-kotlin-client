package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktTrendingShow

data class TraktTrendingShowImpl(override var watchers: Int? = null,
                                 override var show: TraktShowImpl = TraktShowImpl()) : TraktTrendingShow {
    override var title: String
        get() = show.title
        set(title) {
            show.title = title
        }
    override var year: Int?
        get() = show.year
        set(year) {
            show.year = year
        }
    override var ids: TraktShowIdsImpl
        get() = show.ids
        set(ids) {
            show.ids = ids
        }
}
