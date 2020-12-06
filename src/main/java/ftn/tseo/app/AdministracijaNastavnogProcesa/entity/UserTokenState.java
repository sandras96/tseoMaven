package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;

public class UserTokenState {
	
	private String access_token;
	private int id;
	private String authority;

    public UserTokenState() {
        this.access_token = null;
    }

    public UserTokenState(String access_token,int id,String authority) {
        this.access_token = access_token;
        this.id =  id;
        this.authority = authority;
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

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

    

}
