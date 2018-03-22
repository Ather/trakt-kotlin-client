package media.thehoard.thirdparty.api.trakt.objects.post.users.responses.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser;
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl;

import java.util.Date;

public class TraktUserFollowUserPostResponseImpl {
	@SerializedName("approved_at")
	private Date approvedAt;

	private TraktUserImpl user;
}
