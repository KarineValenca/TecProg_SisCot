package model;

public class Provider {
	private String providerCnpj;
	private String providerName;
	private String providerEmail;
	private String providerPassword;
	private int providerDdd;
	private int providerPhone;
	private String ProviderAdress;
	private String ProviderCity;
	private String ProviderState;
	private int ProviderZip;
	private boolean authorized;


	public Provider() {
		super();
	}

	public String getProviderCnpj() {
		return providerCnpj;
	}

	public void setProviderCnpj(String providerCnpj) {
		this.providerCnpj = providerCnpj;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderEmail() {
		return providerEmail;
	}

	public void setProviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}

	public String getProviderPassword() {
		return providerPassword;
	}

	public void setProviderPassword(String providerPassword) {
		this.providerPassword = providerPassword;
	}

	public int getProviderDdd() {
		return providerDdd;
	}

	public void setProviderDdd(int providerDdd) {
		this.providerDdd = providerDdd;
	}

	public int getProviderPhone() {
		return providerPhone;
	}

	public void setProviderPhone(int providerPhone) {
		this.providerPhone = providerPhone;
	}

	public String getProviderAdress() {
		return ProviderAdress;
	}

	public void setProviderAdress(String ProviderAdress) {
		this.ProviderAdress = ProviderAdress;
	}

	public String getProviderCity() {
		return ProviderCity;
	}

	public void setProviderCity(String ProviderCity) {
		this.ProviderCity = ProviderCity;
	}

	public String getProviderState() {
		return ProviderState;
	}

	public void setProviderState(String ProviderState) {
		this.ProviderState = ProviderState;
	}

	public int getProviderZip() {
		return ProviderZip;
	}

	public void setProviderZip(int ProviderZip) {
		this.ProviderZip = ProviderZip;
	}
	
	public boolean isAuthorized() {
		return authorized;
	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

}
