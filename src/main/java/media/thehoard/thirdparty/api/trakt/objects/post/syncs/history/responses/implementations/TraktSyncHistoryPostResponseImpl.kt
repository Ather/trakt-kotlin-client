package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseGroup
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseNotFoundGroup
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl

class TraktSyncHistoryPostResponseImpl : TraktSyncHistoryPostResponse {
    override var added: TraktSyncPostResponseGroup = TraktSyncPostResponseGroupImpl()
    @SerializedName("not_found")
    override var notFound: TraktSyncPostResponseNotFoundGroup = TraktSyncPostResponseNotFoundGroupImpl()
}
