package media.thehoard.thirdparty.api.trakt.objects.post.comments.responses.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl
import media.thehoard.thirdparty.api.trakt.objects.post.comments.responses.TraktCommentPostResponse
import java.time.Instant

data class TraktCommentPostResponseImpl(override var id: Int = 0,
                                        override var parentId: Int? = null,
                                        @SerializedName("created_at")
                                        override var createdAt: Instant = Instant.now(),
                                        @SerializedName("updated_at")
                                        override var updatedAt: Instant? = null,
                                        override var comment: String = "",
                                        override var isSpoiler: Boolean = false,
                                        override var isReview: Boolean = false,
                                        override var replies: Int? = null,
                                        override var likes: Int? = null,
                                        @SerializedName("user_rating")
                                        override var userRating: Float? = null,
                                        override var user: TraktUserImpl = TraktUserImpl(),
                                        override var sharing: TraktSharingImpl = TraktSharingImpl()) : TraktCommentPostResponse