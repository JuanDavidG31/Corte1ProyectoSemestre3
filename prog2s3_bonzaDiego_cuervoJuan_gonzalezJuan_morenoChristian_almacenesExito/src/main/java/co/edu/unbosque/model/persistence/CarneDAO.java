package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.Carne;
import co.edu.unbosque.model.CarneDTO;

public class CarneDAO implements CRUDOperation<CarneDTO, Carne> {

	private ArrayList<Carne> listaCarne;
	private final String FILE_NAME = "carne.csv";
	private final String SERIAL_NAME = "carne.dat";

	public CarneDAO() {
		FileHandler.checkFolder();
		readSerizalized();

	}

	public void setListaCarne(ArrayList<Carne> listaCarne) {
		this.listaCarne = listaCarne;
	}

	public ArrayList<Carne> getListaCarne(int size) {

		if (size > listaCarne.size()) {
			Random rand = new Random();

			ArrayList<Carne> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaCarne.size());
				randomList.add(listaCarne.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaCarne.subList(0, size));
		}

	}

	@Override
	public void delete(int positionToDelete) {
		if (positionToDelete < 0 || positionToDelete >= listaCarne.size()) {
			return;
		} else {
			listaCarne.remove(positionToDelete);
			return;
		}

	}

	@Override
	public String showAll() {
		String rta = "";
		if (listaCarne.isEmpty()) {
			return "No hay Carnes en la lista";
		} else {
			for (Carne Carne : listaCarne) {
				rta += Carne;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<CarneDTO> getAll() {
		return DataMapper.listaCarneToListaCarneDTO(listaCarne);

	}

	@Override
	public boolean add(CarneDTO newData) {

		listaCarne.add(DataMapper.CarneDTOToCarne(newData));
		writeFile();
		writeSerialized();
		return true;

	}

	@Override
	public boolean delete(CarneDTO toDelete) {
		Carne carneToRemove = find2(DataMapper.CarneDTOToCarne(toDelete));
		if (carneToRemove != null) {
			listaCarne.remove(carneToRemove);
			writeFile();
			writeSerialized();
			return true;
		}
		return false;
	}

	@Override
	public boolean update(CarneDTO previous, CarneDTO newData) {
		Carne found = find(DataMapper.CarneDTOToCarne(previous));
		if (found != null) {
			listaCarne.remove(found);
			listaCarne.add(DataMapper.CarneDTOToCarne(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	public void writeFile() {
		String content = "";
		for (Carne m : listaCarne) {
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
			listaCarne = new ArrayList<>();
		} else {
			listaCarne = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				Carne tempo = new Carne();
				tempo.setId(Integer.parseInt(cols[0]));
				tempo.setCode(cols[1]);
				tempo.setName(cols[2]);
				tempo.setDescription(cols[3]);
				tempo.setImage(cols[4]);
				tempo.setPrice(Integer.parseInt(cols[5]));
				tempo.setCategory(cols[6]);
				tempo.setQuantity(Integer.parseInt(cols[7]));
				tempo.setRating(Integer.parseInt(cols[9]));
				listaCarne.add(tempo);
			}
		}

	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, listaCarne);
	}

	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaCarne = new ArrayList<>();
		} else {
			listaCarne = (ArrayList<Carne>) content;
		}
	}

	@Override
	public Carne find(Carne toFind) {
		Carne found = null;
		if (!listaCarne.isEmpty()) {
			for (Carne Carne : listaCarne) {
				if (Carne.getId() == toFind.getId()) {
					found = Carne;
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
	public Carne find2(Carne toFind) {
		Carne found = null;
		if (!listaCarne.isEmpty()) {
			for (Carne Carne : listaCarne) {
				if (Carne.getCode().equals(toFind.getCode())) {
					found = Carne;
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
