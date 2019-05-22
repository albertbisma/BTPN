package org.spring.service;

import java.util.List;

import org.spring.dao.NasabahDao;
import org.spring.model.Nasabah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.Errorexception;

@Service
public class NasabahService {
	@Autowired
	NasabahDao nasabahDao;
		
	Nasabah nasabah;
	
	public void insert(Nasabah nasabah) throws Errorexception{
		if(nasabah.getNama().isEmpty()) {
			throw new Errorexception("Name is required!");
		}
		if(nasabah.getNoRek().isEmpty()) {
			throw new Errorexception("No Rek is required!");
		}
		if(nasabah.getAddress().isEmpty()) {
			throw new Errorexception("Address is required!");
		}
		System.out.println("lolosService");
		nasabahDao.save(nasabah);
	}
	
	public void update(Nasabah nasabah) throws Errorexception{
		if(nasabah.getId().isEmpty()) {
			throw new Errorexception("Data is not found!");
		}
		if(!getById(nasabah.getId()).equals(nasabahDao.getById(nasabah.getId()))) {
			throw new Errorexception("Id can't change!");
		}
		if(nasabah.getNama().isEmpty()) {
			throw new Errorexception("Nama is required!");
		}
		if(nasabah.getNoRek().isEmpty()) {
			throw new Errorexception("No Rekening is Required!");
		}
		if(nasabah.getAddress().isEmpty()) {
			throw new Errorexception("Address is required!");
		}		
		if (!getById(nasabah.getId()).equals(nasabahDao.getByBk(nasabah.getNama()))) {
			throw new Errorexception("Nama Nasabah can't change!");		
		}
		nasabahDao.update(nasabah);
	}
	
	public void delete(String id) throws Errorexception{
		if(isIdExists(id)) {
			nasabahDao.delete(getById(id));
		}else {
			throw new Errorexception("Data tidak ditemukan");
		}
	}
	
	public List<Nasabah> getAll() {
		return nasabahDao.getAll();
	}
	
	public Nasabah getById(String id) {
		return nasabahDao.getById(id);
	}
	
	public boolean isIdExists(String id) {
		if((getById(id)).getId().isEmpty()){
			return false;		
		}else {
			return true;
		}
	}
}
