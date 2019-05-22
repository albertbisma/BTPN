package org.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_nasabah", uniqueConstraints = @UniqueConstraint(columnNames = "no_rek"))
public class Nasabah {
	public Nasabah() {
		
	}
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name ="nama")
	private String nama;
	
	@Column(name = "no_rek")
	private String noRek;
	
	@Column(name = "address")
	private String address;
	
	@Column(name="createdat")	
	private Date createdAt;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNoRek() {
		return noRek;
	}

	public void setNoRek(String noRek) {
		this.noRek = noRek;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
