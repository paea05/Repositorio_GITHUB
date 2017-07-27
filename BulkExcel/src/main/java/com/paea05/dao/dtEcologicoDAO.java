package com.paea05.dao;

import com.paea05.beans.dtEcologico;

public interface dtEcologicoDAO {
	public String consHosp(String nH);
	public String consConv(String nC);
	public String consEquip(String nE);
	public String consEspec(String nEs);
	public int insertDtCoorp(dtEcologico dE);
}
