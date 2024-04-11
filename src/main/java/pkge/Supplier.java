package pkge;

public class Supplier {
	private int supplier_id;
    private String name;
    private String contact_person;
	private String email;
    private String phone_number;
    private String address;
    
    public Supplier(int supplier_id, String name, String contact_person, String email, String phone_number,String address) {
		this.supplier_id = supplier_id;
		this.name = name;
		this.contact_person = contact_person;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
	}    
    
	
	
	public int getSupplier_id() {
		return supplier_id;
	}


	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContact_person() {
		return contact_person;
	}


	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


//	@Override
//	public String toString() {
//		return "Supplier [supplier_id="+supplier_id+",name"+name+",contact_person"+contact_person+",email"+email+",phone_number"+phone_number+",address"+address+"]";
//	}
    
}
