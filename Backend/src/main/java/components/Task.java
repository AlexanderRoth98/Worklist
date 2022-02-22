package components;

public class Task {
	private String uiLink;
	private String role;
	private String label;

	public Task(String uiLink, String role, String label) {
		super();
		this.uiLink = uiLink;
		this.role = role;
		this.label = label;
	}

	public Task() {
		super();
	}

	public String getUiLink() {
		return uiLink;
	}

	public void setUiLink(String uiLink) {
		this.uiLink = uiLink;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
