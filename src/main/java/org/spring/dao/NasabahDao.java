package org.spring.dao;

import java.util.List;

import javax.persistence.Query;

import org.spring.model.Nasabah;
import org.springframework.stereotype.Repository;


@Repository
public class NasabahDao extends ParentDao {
	
	public void delete(Nasabah nasabah) {
		super.entityManager.remove(nasabah);
	}
	
	public void update(Nasabah nasabah) {
		super.entityManager.merge(nasabah);
	}
			
	public void save(Nasabah nasabah) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tbl_nasabah(id, nama, no_rek, address)")
		   .append("VALUES(REPLACE(CONCAT(:nama,current_time),':',''), :nama, :noRekening, :alamat); ");
		
		Query query = super.entityManager.createNativeQuery(sql.toString())
										 .setParameter("nama", nasabah.getNama())
										 .setParameter("noRekening", nasabah.getNoRek())
										 .setParameter("alamat", nasabah.getAddress());		
		query.executeUpdate();
	}
	
	public List<Nasabah> getAll() {
		List<Nasabah> nasabah = super.entityManager.createQuery("FROM Nasabah").getResultList();
		return nasabah;
	}
	
	@SuppressWarnings("unchecked")
	public Nasabah getById(String id) {
		List<Nasabah> nasabah = super.entityManager
							   .createQuery("from Nasabah where id=:idNasabah")
							   .setParameter("idNasabah", id)
							   .getResultList();
		if(nasabah.size() == 0) {
			return new Nasabah();
		}else {
			return (Nasabah)nasabah.get(0);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Nasabah getByBk(String nama) {
		List<Nasabah> nasabah = super.entityManager
							 .createQuery("from Nasabah where nama=:namanasabah")
							 .setParameter("namanasabah", nama)
							 .getResultList();
		if(nasabah.size()==0) {
			return new Nasabah();
		}else {
			return (Nasabah)nasabah.get(0);
		}
	}
		

}
