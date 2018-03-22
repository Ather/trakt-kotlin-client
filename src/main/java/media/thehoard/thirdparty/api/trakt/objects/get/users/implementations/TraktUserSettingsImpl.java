package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktAccountSettings;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktSharingText;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserSettings;

public class TraktUserSettingsImpl implements TraktUserSettings {
	private TraktUserImpl user;
	private TraktAccountSettings account;
	private TraktSharingImpl connections;
	@SerializedName("sharing_text")
	private TraktSharingText sharingText;

	@Override
	public TraktUser getUser() {
		return user;
	}

	@Override
	public void setUser(TraktUserImpl user) {
		this.user = user;
	}

	@Override
	public TraktUserSettings withUser(TraktUserImpl user) {
		this.user = user;
		return this;
	}

	@Override
	public TraktAccountSettings getAccount() {
		return account;
	}

	@Override
	public void setAccount(TraktAccountSettings account) {
		this.account = account;
	}

	@Override
	public TraktUserSettings withAccount(TraktAccountSettings account) {
		this.account = account;
		return this;
	}

	@Override
	public TraktSharingImpl getConnections() {
		return connections;
	}

	@Override
	public void setConnections(TraktSharingImpl connections) {
		this.connections = connections;
	}

	@Override
	public TraktUserSettings withConnections(TraktSharingImpl connections) {
		this.connections = connections;
		return this;
	}

	@Override
	public TraktSharingText getSharingText() {
		return sharingText;
	}

	@Override
	public void setSharingText(TraktSharingText sharingText) {
		this.sharingText = sharingText;
	}

	@Override
	public TraktUserSettings withSharingText(TraktSharingText sharingText) {
		this.sharingText = sharingText;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserSettingsImpl that = (TraktUserSettingsImpl) o;

		if (user != null ? !user.equals(that.user) : that.user != null) return false;
		if (account != null ? !account.equals(that.account) : that.account != null) return false;
		if (connections != null ? !connections.equals(that.connections) : that.connections != null) return false;
		return sharingText != null ? sharingText.equals(that.sharingText) : that.sharingText == null;
	}

	@Override
	public int hashCode() {
		int result = user != null ? user.hashCode() : 0;
		result = 31 * result + (account != null ? account.hashCode() : 0);
		result = 31 * result + (connections != null ? connections.hashCode() : 0);
		result = 31 * result + (sharingText != null ? sharingText.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktUserSettings{" + "user=" + user + ", account=" + account + ", connections=" + connections + ", sharingText=" + sharingText + '}';
	}
}
