package media.thehoard.thirdparty.api.trakt.objects.basic.implementations;

public class TraktNetworkImpl implements media.thehoard.thirdparty.api.trakt.objects.basic.TraktNetwork {
	private String network;

	@Override
	public String getNetwork() {
		return network;
	}

	@Override
	public void setNetwork(String network) {
		this.network = network;
	}

	@Override
	public media.thehoard.thirdparty.api.trakt.objects.basic.TraktNetwork withNetwork(String network) {
		this.network = network;
		return this;

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktNetworkImpl that = (TraktNetworkImpl) o;

		return network != null ? network.equals(that.network) : that.network == null;
	}

	@Override
	public int hashCode() {
		return network != null ? network.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "TraktNetwork{" + "network='" + network + '\'' + '}';
	}
}
