package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history

interface TraktSyncHistoryRemovePost : TraktSyncHistoryPost {
    val ids: MutableList<Long>
}