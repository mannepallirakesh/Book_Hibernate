package com.training;

import javax.persistence.*;

@Entity
@Table(name="Books")
public class Books {
	@Id
	@GeneratedValue
	
	@Column(name = "ID")
	private Long bkId;	

	@Column(name = "NAME")
	private String bkName;

	@Column(name = "AUTHOR")
	private String aName;
	
	@Column(name = "PRICE")
	private int bkPrc;	

	public Books() {
	}
	public Long getId() {
		return bkId;
	}

	public void setId(Long bkId) {
		this.bkId = bkId;
	}
	

	public String getName() {
		return bkName;
	}

	public void setName(String bkName) {
		this.bkName = bkName;
	}

	public String getAuthor() {
		return aName;
	}

	public void setAuthor(String aName) {
		this.aName = aName;
	}
	
	public int getPrice() {
		return bkPrc;
	}

	public void setPrice(int bkPrc) {
		this.bkPrc = bkPrc;
	}
	

	@Override
	public String toString() {
		return "Books [ID = " +bkId+", NAME=" + bkName
				+ ", AUTHOR=" + aName + ", PRICE = "+bkPrc+"]";
	}

}