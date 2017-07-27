package com.msd.ham.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class moverDir {
	private static final Date fechaHoy = new Date();
	private static final SimpleDateFormat formatoCarp = new SimpleDateFormat("yyyy/MMMM");
	private static final String fNERt = formatoCarp.format(fechaHoy);

	private static final SimpleDateFormat formatomes = new SimpleDateFormat("MMMM yy");
	private static final String fNEPre = "ATV ";
	private static final String fNEMes = formatomes.format(fechaHoy);
	private static final String fNEPost = " Revisión.xlsx";
	private static final String fNEComp = fNEPre + fNEMes + fNEPost;

	public void moveFile(String O, String D) {
		System.out.println("Desde: " + O.replace(fNEComp, ""));
		System.out.println("Hacia: " + D.replace(fNEComp, "") + fNERt);
		try {
			File enArch = new File(O);
			File salArch = new File(D.replace(fNEComp, "") + fNERt);

			File carpFinal = new File(salArch, fNEComp);

			salArch.mkdirs();

			FileInputStream entrada = new FileInputStream(enArch);
			FileOutputStream salida = new FileOutputStream(carpFinal);

			int c;
			while ((c = entrada.read()) != -1)
				salida.write(c);

			entrada.close();
			salida.close();

			File Archivo = new File(O);
			if (Archivo.exists()) {
				Archivo.delete();
			}
		} catch (Exception e) {
			System.err.println("Hubo un error de entrada/salida!!! : " + e.getMessage());
		}
	}

	public void moverArchivo(String O, String D) {
		Path oPath = FileSystems.getDefault().getPath(O);
		Path dPath = FileSystems.getDefault().getPath(D);

		System.out.println("Desde: " + O);
		System.out.println("Hacia: " + D);

		try {
			Files.move(oPath, dPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			System.err.println("Hubo un error de entrada/salida!!! : " + e.getMessage());
		}
	}
}
