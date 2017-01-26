package com.training;

import javax.persistence.*;

@Entity
@Table(name="MEM")
public class Mem {
	@Id
	@GeneratedValue
	
	@Column(name = "MEMID")
	private long memId;	

	@Column(name = "MEMNAME")
	private String memName;

	@Column(name = "MEMPASS")
	private String memPass;

	public Mem() {
	}
	public Long getMemId() {
		return memId;
	}

	public void setMemId(Long memId) {
		this.memId = memId;
	}
	

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPass() {
		return memPass;
	}

	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}

	@Override
	public String toString() {
		return "Mem [MEMID = " +memId+", MEMNAME=" + memName
				+ ", MEMPASS=" + memPass + "]";
	}

}