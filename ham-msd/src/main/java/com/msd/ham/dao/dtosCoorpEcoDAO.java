package com.msd.ham.dao;

import com.msd.ham.models.dtosCoorpEco;

public interface dtosCoorpEcoDAO {
	public String consHosp(String nH);
	public String consConv(String nC);
	public String consEquip(String nE);
	public String consEspec(String nEs);
	public int insertDtCoorp(dtosCoorpEco dE);
}
