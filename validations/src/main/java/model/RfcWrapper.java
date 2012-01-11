package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="rfcWrapper")
@SessionScoped
public class RfcWrapper {
	
	private RFC rfc;

	public RFC getRfc() {
		return rfc;
	}

	public void setRfc(RFC rfc) {
		this.rfc = rfc;
	}
	
	public String validate()
	{
		return "rfc";
	}
	

}
