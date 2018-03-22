package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl;

public interface TraktUserSettings {
	TraktUser getUser();

	void setUser(TraktUserImpl user);

	TraktUserSettings withUser(TraktUserImpl user);

	TraktAccountSettings getAccount();

	void setAccount(TraktAccountSettings account);

	TraktUserSettings withAccount(TraktAccountSettings account);

	TraktSharingImpl getConnections();

	void setConnections(TraktSharingImpl connections);

	TraktUserSettings withConnections(TraktSharingImpl connections);

	TraktSharingText getSharingText();

	void setSharingText(TraktSharingText sharingText);

	TraktUserSettings withSharingText(TraktSharingText sharingText);
}
