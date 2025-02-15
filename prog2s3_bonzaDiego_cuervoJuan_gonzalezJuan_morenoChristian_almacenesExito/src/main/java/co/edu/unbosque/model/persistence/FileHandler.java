package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;

public class FileHandler {
	private static Scanner sc;
	private static PrintWriter pw;
	private static File archivo;
	private static final String FOLDER_NAME = "data";
	private static final String CONFIG_FOLDER_NAME = "config";

	// archivo serializado
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;

	private static FileInputStream fis;
	private static ObjectInputStream ois;

	public static Object readSerialized(String url) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();

			}
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			Object content = ois.readObject();
			fis.close();
			ois.close();
			return content;
		} catch (IOException e) {
			System.out.println("Error en la lectura del archivo serializado");
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la lectura del archivo serializado(class not found)");
			// e.printStackTrace();
		}
		return null;

	}

	public static void writerSerialized(String url, Object content) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();

			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(content);
			fos.close();
			oos.close();
		} catch (IOException e) {
			System.out.println("Error en la escritura del archivo");
		}
	}

	public static void checkFolder() {
		archivo = new File(FOLDER_NAME);
		if (archivo.exists() && archivo.isDirectory()) {
			return;
		} else {
			archivo.mkdir();
		}

		archivo = new File(CONFIG_FOLDER_NAME);
		if (archivo.exists() && archivo.isDirectory()) {
			return;
		} else {
			archivo.mkdir();
		}

	}

	public static void writeFile(String url, String content) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();

			}
			pw = new PrintWriter(archivo);
			pw.write(content);
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error en la escritura del archivo(Texto plano)");
		} catch (IOException e) {
			System.out.println("Error en la correcion del archivo(Texto plano)");
		}
	}

	public static String readFile(String url) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			sc = new Scanner(archivo);
			String content = "";
			while (sc.hasNext()) {
				content += sc.nextLine() + "\n";

			}
			return content;

		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

	public static Properties loadProperties(String url) {
		Properties prop = null;
		prop = new Properties();
		try {
			prop.load(new FileInputStream(CONFIG_FOLDER_NAME + "/" + url));
		} catch (FileNotFoundException e) {
			System.out.println("Ruta del archivo no encontrado");
			System.out.println(CONFIG_FOLDER_NAME + "/" + url);
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo de propiedades");
			// e.printStackTrace();
		}

		return prop;

	}

}
