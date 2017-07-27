package com.msd.ham.dao;

import java.util.List;

import com.msd.ham.models.ventas;

public interface cargarExcelBulkDAO {
	public int[] insertBulkVtas (List<ventas> vt, String DE, String DS, String DER);
//	public int[] insertBulkVtas (ventas vt);
}
