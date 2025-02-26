package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.Lacteo;
import co.edu.unbosque.model.LacteoDTO;
import co.edu.unbosque.model.InventoryStatus;
import co.edu.unbosque.model.Product;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped

public class LacteoDAO implements CRUDOperation<LacteoDTO, Lacteo> {

	private ArrayList<Lacteo> listaLacteo;
	private final String FILE_NAME = "lacteo.csv";
	private final String SERIAL_NAME = "lacteo.dat";

	public LacteoDAO() {
		FileHandler.checkFolder();
		readSerizalized();

	}

	public void setListaLacteo(ArrayList<Lacteo> listaLacteo) {
		this.listaLacteo = listaLacteo;
	}

	public ArrayList<Lacteo> getListaLacteo(int size) {

		if (size > listaLacteo.size()) {
			Random rand = new Random();

			ArrayList<Lacteo> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaLacteo.size());
				randomList.add(listaLacteo.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaLacteo.subList(0, size));
		}

	}

	public ArrayList<Lacteo> getClonedLacteo(int size) {
		ArrayList<Lacteo> results = new ArrayList<>();
		ArrayList<Lacteo> originals = getListaLacteo(size);
		for (Lacteo original : originals) {
			results.add((original));
		}

		for (Lacteo product : results) {
			product.setCode(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}

	@Override
	public void delete(int positionToDelete) {
		if (positionToDelete < 0 || positionToDelete >= listaLacteo.size()) {
			return;
		} else {
			listaLacteo.remove(positionToDelete);
			return;
		}

	}

	@Override
	public String showAll() {
		String rta = "";
		if (listaLacteo.isEmpty()) {
			return "No hay Lacteos en la lista";
		} else {
			for (Lacteo Lacteo : listaLacteo) {
				rta += Lacteo;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<LacteoDTO> getAll() {
		return DataMapper.listaLacteoToListaLacteoDTO(listaLacteo);

	}

	@Override
	public boolean add(LacteoDTO newData) {

		listaLacteo.add(DataMapper.LacteoDTOToLacteo(newData));
		writeFile();
		writeSerialized();
		return true;

	}

	@Override
	public boolean delete(LacteoDTO toDelete) {
		Lacteo found = find(DataMapper.LacteoDTOToLacteo(toDelete));
		if (found != null) {
			listaLacteo.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(LacteoDTO previous, LacteoDTO newData) {
		Lacteo found = find(DataMapper.LacteoDTOToLacteo(previous));
		if (found != null) {
			listaLacteo.remove(found);
			listaLacteo.add(DataMapper.LacteoDTOToLacteo(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	public void writeFile() {
		String content = "";
		for (Lacteo m : listaLacteo) {
			content += m.getId() + ";";
			content += m.getCode() + ";";
			content += m.getName() + ";";
			content += m.getDescription() + ";";
			content += m.getImage() + ";";
			content += m.getPrice() + ";";
			content += m.getCategory() + ";";
			content += m.getQuantity() + ";";
			content += m.getInventoryStatus() + ";";
			content += m.getRating() + ";";
			content += m.getOrders() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) {
			listaLacteo = new ArrayList<>();
		} else {
			listaLacteo = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				Lacteo tempo = new Lacteo();
				tempo.setId(Integer.parseInt(cols[0]));
				tempo.setCode(cols[1]);
				tempo.setName(cols[2]);
				tempo.setDescription(cols[3]);
				tempo.setImage(cols[4]);
				tempo.setPrice(Integer.parseInt(cols[5]));
				tempo.setCategory(cols[6]);
				tempo.setQuantity(Integer.parseInt(cols[7]));
				tempo.setRating(Integer.parseInt(cols[9]));
				listaLacteo.add(tempo);
			}
		}

	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, listaLacteo);
	}

	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaLacteo = new ArrayList<>();
		} else {
			listaLacteo = (ArrayList<Lacteo>) content;
		}
	}

	@Override
	public Lacteo find(Lacteo toFind) {
		Lacteo found = null;
		if (!listaLacteo.isEmpty()) {
			for (Lacteo Lacteo : listaLacteo) {
				if (Lacteo.getId() == toFind.getId()) {
					found = Lacteo;
					return found;
				} else {
					continue;
				}
			}
		} else {
			return null;
		}
		return null;
	}

	@Override
	public Lacteo find2(Lacteo toFind) {
		// TODO Auto-generated method stub
		return null;
	}
}
