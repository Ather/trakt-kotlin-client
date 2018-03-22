package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses.implementations;

import media.thehoard.thirdparty.api.trakt.enums.TraktScrobbleActionType;
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktSharing;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl;

public abstract class AbstractTraktScrobblePostResponse {
	private long id;
	private TraktScrobbleActionType action;
	private Float progress;
	private TraktSharingImpl sharing;
}
