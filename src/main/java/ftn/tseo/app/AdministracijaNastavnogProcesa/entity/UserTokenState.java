package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;

import java.util.List;

public class UserTokenState {
	
	private String access_token;
	private String type = "Bearer";
	private int id;
	private List<String> authorities;
	private String username;
	private boolean deleted;



    public UserTokenState(String access_token, int id, String username, boolean deleted, List<String> authorities) {
		super();
		this.access_token = access_token;
		this.id = id;
		this.authorities = authorities;
		this.username = username;
		this.deleted = deleted;
	}

	public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

    

}