package demo.model;

public class Authority {

	private String username;
	private String authority = "ROLE_USER";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = "ROLE_" + authority;
	}

}
