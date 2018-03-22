package media.thehoard.thirdparty.api.trakt.objects.post.users.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.enums.TraktAccessScope;

public class TraktUserCustomListPostImpl {
	private String name;
	private String description;
	private TraktAccessScope privacy;
	@SerializedName("display_numbers")
	private Boolean displayNumbers;
	@SerializedName("allow_comments")
	private Boolean allowComments;
}
