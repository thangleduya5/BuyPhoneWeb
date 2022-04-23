package ptithcm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class DetailBillPK implements Serializable{
	
	@ManyToOne 
	private Bill bill;
	
	@ManyToOne 
	private Phone phone;
	
	public DetailBillPK() {
		
	}

	public DetailBillPK(Bill bill, Phone phone) {
		super();
		this.bill = bill;
		this.phone = phone;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

}

