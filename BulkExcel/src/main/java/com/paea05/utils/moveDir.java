package com.paea05.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class moveDir {

	public void moverArchivo(String O, String D) {
		System.out.println("Desde: " + O);
		System.out.println("Hacia: " + D);
		try {
			File enArch = new File(O);
			File salArch = new File(D);

			FileInputStream entrada = new FileInputStream(enArch);
			FileOutputStream salida = new FileOutputStream(salArch);

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
}
