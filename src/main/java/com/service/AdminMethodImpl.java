package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.AdminRepository;
import com.converter.DTOconverter;
import com.dto.AdminDTO;
import com.model.Admin;
@Service
public class AdminMethodImpl implements AdminMethod{
	@Autowired
	private AdminRepository adm;
	@Autowired
	private DTOconverter dtOconverter;
	@Override
	public boolean existsByUsernameAndPassword(String user, String pass) {
		// TODO Auto-generated method stub
		Iterable<Admin> list=adm.findAll();
		for(Admin a:list) {
			if(a.getUsername().equals(user) && a.getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public Iterable<Admin> findAll() {
		// TODO Auto-generated method stub
		return adm.findAll();
	}
	@Override
	public List<AdminDTO> getfindAll() {
		// TODO Auto-generated method stub
		List<AdminDTO> lAdminDTOs=new ArrayList<>();
		List<Admin> list = adm.findAll();
		for(Admin a:list) {
			lAdminDTOs.add(dtOconverter.toDTO(a));
		}
		return lAdminDTOs;
	}

}
