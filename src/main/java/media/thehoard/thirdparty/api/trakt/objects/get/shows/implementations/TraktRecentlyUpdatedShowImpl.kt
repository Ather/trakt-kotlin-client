package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktRecentlyUpdatedShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow

import java.time.Instant

data class TraktRecentlyUpdatedShowImpl(@SerializedName("updated_at")
                                        override var updatedAt: Instant? = null,
                                        override var show: TraktShowImpl = TraktShowImpl()) : TraktRecentlyUpdatedShow {
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
