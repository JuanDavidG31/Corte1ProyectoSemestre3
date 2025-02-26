package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.Juguete;
import co.edu.unbosque.model.JugueteDTO;
import co.edu.unbosque.model.InventoryStatus;
import co.edu.unbosque.model.Product;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped

public class JugueteDAO implements CRUDOperation<JugueteDTO, Juguete> {

	private ArrayList<Juguete> listaJuguete;
	private final String FILE_NAME = "juguete.csv";
	private final String SERIAL_NAME = "juguete.dat";

	public JugueteDAO() {
		FileHandler.checkFolder();
		readSerizalized();

	}

	public void setListaJuguete(ArrayList<Juguete> listaJuguete) {
		this.listaJuguete = listaJuguete;
	}

	public ArrayList<Juguete> getListaJuguete(int size) {

		if (size > listaJuguete.size()) {
			Random rand = new Random();

			ArrayList<Juguete> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaJuguete.size());
				randomList.add(listaJuguete.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaJuguete.subList(0, size));
		}

	}

	public ArrayList<Juguete> getClonedJuguete(int size) {
		ArrayList<Juguete> results = new ArrayList<>();
		ArrayList<Juguete> originals = getListaJuguete(size);
		for (Juguete original : originals) {
			results.add((original));
		}

		for (Juguete product : results) {
			product.setCode(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}

	@Override
	public void delete(int positionToDelete) {
		if (positionToDelete < 0 || positionToDelete >= listaJuguete.size()) {
			return;
		} else {
			listaJuguete.remove(positionToDelete);
			return;
		}

	}

	@Override
	public String showAll() {
		String rta = "";
		if (listaJuguete.isEmpty()) {
			return "No hay Juguetes en la lista";
		} else {
			for (Juguete Juguete : listaJuguete) {
				rta += Juguete;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<JugueteDTO> getAll() {
		return DataMapper.listaJugueteToListaJugueteDTO(listaJuguete);

	}

	@Override
	public boolean add(JugueteDTO newData) {

		listaJuguete.add(DataMapper.JugueteDTOToJuguete(newData));
		writeFile();
		writeSerialized();
		return true;

	}

	@Override
	public boolean delete(JugueteDTO toDelete) {
		Juguete found = find(DataMapper.JugueteDTOToJuguete(toDelete));
		if (found != null) {
			listaJuguete.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(JugueteDTO previous, JugueteDTO newData) {
		Juguete found = find(DataMapper.JugueteDTOToJuguete(previous));
		if (found != null) {
			listaJuguete.remove(found);
			listaJuguete.add(DataMapper.JugueteDTOToJuguete(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	public void writeFile() {
		String content = "";
		for (Juguete m : listaJuguete) {
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
			listaJuguete = new ArrayList<>();
		} else {
			listaJuguete = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				Juguete tempo = new Juguete();
				tempo.setId(Integer.parseInt(cols[0]));
				tempo.setCode(cols[1]);
				tempo.setName(cols[2]);
				tempo.setDescription(cols[3]);
				tempo.setImage(cols[4]);
				tempo.setPrice(Integer.parseInt(cols[5]));
				tempo.setCategory(cols[6]);
				tempo.setQuantity(Integer.parseInt(cols[7]));
				tempo.setRating(Integer.parseInt(cols[9]));
				listaJuguete.add(tempo);
			}
		}

	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, listaJuguete);
	}

	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaJuguete = new ArrayList<>();
		} else {
			listaJuguete = (ArrayList<Juguete>) content;
		}
	}

	@Override
	public Juguete find(Juguete toFind) {
		Juguete found = null;
		if (!listaJuguete.isEmpty()) {
			for (Juguete Juguete : listaJuguete) {
				if (Juguete.getId() == toFind.getId()) {
					found = Juguete;
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
	public Juguete find2(Juguete toFind) {
		// TODO Auto-generated method stub
		return null;
	}
}
