package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.Ropa;
import co.edu.unbosque.model.RopaDTO;
import co.edu.unbosque.model.Carne;
import co.edu.unbosque.model.InventoryStatus;
import co.edu.unbosque.model.Product;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped

public class RopaDAO implements CRUDOperation<RopaDTO, Ropa> {

	private ArrayList<Ropa> listaRopa;
	private final String FILE_NAME = "ropa.csv";
	private final String SERIAL_NAME = "ropa.dat";

	public RopaDAO() {
		FileHandler.checkFolder();
		readSerizalized();

	}

	public void setListaRopa(ArrayList<Ropa> listaRopa) {
		this.listaRopa = listaRopa;
	}

	public ArrayList<Ropa> getListaRopa(int size) {

		if (size > listaRopa.size()) {
			Random rand = new Random();

			ArrayList<Ropa> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaRopa.size());
				randomList.add(listaRopa.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaRopa.subList(0, size));
		}

	}

	public ArrayList<Ropa> getClonedRopa(int size) {
		ArrayList<Ropa> results = new ArrayList<>();
		ArrayList<Ropa> originals = getListaRopa(size);
		for (Ropa original : originals) {
			results.add((original));
		}

		for (Ropa product : results) {
			product.setCode(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}

	@Override
	public void delete(int positionToDelete) {
		if (positionToDelete < 0 || positionToDelete >= listaRopa.size()) {
			return;
		} else {
			listaRopa.remove(positionToDelete);
			return;
		}

	}

	@Override
	public String showAll() {
		String rta = "";
		if (listaRopa.isEmpty()) {
			return "No hay Ropas en la lista";
		} else {
			for (Ropa Ropa : listaRopa) {
				rta += Ropa;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<RopaDTO> getAll() {
		return DataMapper.listaRopaToListaRopaDTO(listaRopa);

	}

	@Override
	public boolean add(RopaDTO newData) {

		listaRopa.add(DataMapper.RopaDTOToRopa(newData));
		writeFile();
		writeSerialized();
		return true;

	}

	@Override
	public boolean delete(RopaDTO toDelete) {
		Ropa found = find2(DataMapper.RopaDTOToRopa(toDelete));
		if (found != null) {
			listaRopa.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(RopaDTO previous, RopaDTO newData) {
		Ropa found = find2(DataMapper.RopaDTOToRopa(previous));
		if (found != null) {
			listaRopa.remove(found);
			listaRopa.add(DataMapper.RopaDTOToRopa(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	public void writeFile() {
		String content = "";
		for (Ropa m : listaRopa) {
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
			listaRopa = new ArrayList<>();
		} else {
			listaRopa = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				Ropa tempo = new Ropa();
				tempo.setId(Integer.parseInt(cols[0]));
				tempo.setCode(cols[1]);
				tempo.setName(cols[2]);
				tempo.setDescription(cols[3]);
				tempo.setImage(cols[4]);
				tempo.setPrice(Integer.parseInt(cols[5]));
				tempo.setCategory(cols[6]);
				tempo.setQuantity(Integer.parseInt(cols[7]));
				tempo.setRating(Integer.parseInt(cols[9]));
				listaRopa.add(tempo);
			}
		}

	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, listaRopa);
	}

	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaRopa = new ArrayList<>();
		} else {
			listaRopa = (ArrayList<Ropa>) content;
		}
	}

	@Override
	public Ropa find(Ropa toFind) {
		Ropa found = null;
		if (!listaRopa.isEmpty()) {
			for (Ropa Ropa : listaRopa) {
				if (Ropa.getId() == toFind.getId()) {
					found = Ropa;
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
	public Ropa find2(Ropa toFind) {
		Ropa found = null;
		if (!listaRopa.isEmpty()) {
			for (Ropa Ropa : listaRopa) {
				if (Ropa.getCode().equals(toFind.getCode())) {
					found = Ropa;
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
}
