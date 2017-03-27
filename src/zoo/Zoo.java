/* File     : Driver.java */
/* Author     : Andika Kusuma dan Reinaldo Ignatius Wijaya */

package zoo;

import java.io.FileInputStream;
import java.util.ArrayList;

/** \brief Class Zoo
 * \details Kelas Zoo yang berisi kebun binatang itu sendiri beserta hewan-hewannya
 */
public class Zoo {
	private int width; /**< dimensi zoo; jumlah baris*/
	private int length;    /**< dimensi zoo; jumlah kolom*/
	private Cell[][] cells; /**< matriks Cell yang dimiliki zoo*/
	private ArrayList<Animal> animals;    /**< daftar Animals yang ada dalam zoo*/
	private int[][] cage_map;    /**< matriks penanda nomor cage dalam zoo*/
	private int cage_nb; /**< jumlah cage yang ada dalam zoo*/

	/**
	 * \brief initCage
	 * \details Mengenerate cage dari matrix cell
	 */
	private void cageInit() {
		int counter = 1;
		for (int i = 0; i < width; ++i) {
			for (int j = 0; j < length; ++j) {
				if (cage_map[i][j] == -99) {
					char c = cells[i][j].GetSymbol();
					if (c != 'W' && c != 'A' && c != 'L') {
						cage_map[i][j] = 0;
					} else {
						int array_i[4];
						int array_j[4];
						for (int k = 0; k < 4; ++k) {
							array_i[k] = i;
							array_j[k] = j;
						}
						boolean cek = true;
						cage_map[i][j] = counter;
						Random random = new Random;
						Pair[] moveable = new Pair [12];
						int ii, jj;
						int i_temp = i;
						int j_temp = j;
						int count = 0;
						for (int times = 0; times < 3; times++) {
							for (int k = 0; k < 4; ++k) {
								boolean dummy = false;
								if (k == 0 && i_temp != 0) {
									ii = i_temp - 1;
									jj = j_temp;
									dummy = true;
								} else if (k == 1 && j_temp != 0) {
									ii = i_temp;
									jj = j_temp - 1;
									dummy = true;
								} else if (k == 2 && i_temp != width - 1) {
									ii = i_temp + 1;
									jj = j_temp;
									dummy = true;
								} else if (k == 3 && j_temp != length - 1) {
									ii = i_temp;
									jj = j_temp + 1;
									dummy = true;
								}
								if (dummy) {
									if (cells[ii][jj].GetSymbol() == c && cage_map[ii][jj] == -99) {
										moveable[count].first = ii;
										moveable[count].second = jj;
										++count;
									}
								}
							}
							if (count == 0) {
								cek = false;
								break;
							}
							int move = random.nextInt(count);
							i_temp = moveable[move].first;
							j_temp = moveable[move].second;
							array_i[times] = i_temp;
							array_j[times] = j_temp;
							moveable[move].first = moveable[count-1].first;
							moveable[move].second = moveable[count-1].second;
							--count;
							if (times == 2) {
								++counter;
							}
						}
						if (!cek) {
							for (int k = 0; k < 4; ++k) {
								cage_map[array_i[k]][array_j[k]] = -99;
							}
						}
					}
				}
			}
		}
		cage_nb = counter - 1;
		int change = -1;
		while (change != 0) {
			change = 0;
			for (int i = 0; i < width; ++i) {
				for (int j = 0; j < length; ++j) {
					if (cage_map[i][j] == -99) {
						Pair moveable = new Pair [4];
						int count = 0;
						int ii, jj;
						for (int k = 0; k < 4; ++k) {
							boolean dummy = false;
							if (k == 0 && i != 0) {
								ii = i - 1;
								jj = j;
								dummy = true;
							} else if (k == 1 && j != 0) {
								ii = i;
								jj = j - 1;
								dummy = true;
							} else if (k == 2 && i != width - 1) {
								ii = i + 1;
								jj = j;
								dummy= true;
							} else if (k == 3 && i != length - 1) {
								ii = i;
								jj = j + 1;
								dummy = true;
							}
							if (dummy) {
								if (cells[ii][jj].GetSymbol() == cells[i][j].GetSymbol() && cage_map[ii][jj] != -99) {
									moveable[count].first = ii;
									moveable[count].second = jj;
									++change;
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * \brief Constructor
	 * \details Mengenerate kebun binatang dari file eksternal denangan list hewan kosong
	 */
	public Zoo() {
		width = 33;
		length = 32;
		cells = new Cell* [width];
		for (int i = 0; i < width; ++i) {
			cells[i] = new Cell;
		}
		Scanner scanner = new Scanner(new FileInputStream("asset/map.txt"));
		StringBuffer line = new StringBuffer(50);
		int i = 0;
		while (scanner.hasNext()) {
			line = scanner.nextLine();
			for (int j = 0; j < length; ++j) {
					switch (line.charAt(j)) {
						case 'W': {
							cells[i][j].setInitSymbol('W');
							cells[i][j].setSymbol('W');
						}
						break;
						case 'A': {
							cells[i][j].setInitSymbol('A');
							cells[i][j].setSymbol('A');
						}
						break;
						case 'L': {
							cells[i][j].setInitSymbol('L');
							cells[i][j].setSymbol('L');
						}
						break;
						case 'X': {
							cells[i][j].setInitSymbol('X');
							cells[i][j].setSymbol('X');
						}
						break;
						case 'N': {
							cells[i][j].setInitSymbol('N');
							cells[i][j].setSymbol('N');
						}
						case 'r': {
							cells[i][j].setInitSymbol('r');
							cells[i][j].setSymbol('r');
						}
						break;
						case 'R': {
							cells[i][j].setInitSymbol('R');
							cells[i][j].setSymbol('R');
						}
						break;
						case 'P': {
							cells[i][j].setInitSymbol('P');
							cells[i][j].setSymbol('P');
						}
						break;
					}
			}
			++i;
		}
		cage_map = new int* [width];
		for (int i = 0; i < width; ++i) {
			cage_map[i] = new int[length];
			for (int j = 0; j < length; ++j) {
				cage_map[i][j] = -99;
			}
		}
		cageInit();
		scanner = new Scanner(new FileInputStream("asset/animals.txt"));
		while (scanner.hasNext()) {
			line = scanner.nextLine();
			StringBuffer id = new StringBuffer();
			int px = 0;
			int py = 0;
			int j = 0;
			int weight = 0;
			int decimal_weight = 0;
			while (line.charAt((j)) != '|') {
				id.append(line.charAt((j)));
				++j;
			}
			++j;
			while (line.charAt(j) != '|') {
				px = 10 * px + line.charAt(j) - '0';
				++j;
			}
			++j;
			while (j < line.length() && line.charAt(j) != '|') {
				py = 10 * py + line.charAt(j) - '0';
				++j;
			}
			if (line.charAt(j) == '|') {
				++j;
				while (line.charAt(j) != '.' && j < line.length()) {
					weight = 10 * weight + line.charAt(j) - '0';
					++j;
				}
				if (line.charAt(j) == '.') {
					int multiplier = 1;
					while (j < line.length()) {
						multiplier *= 0.1;
						decimal_weight += multiplier * (line.charAt(j) - '0');
						++j;
					}
				}
				weight += decimal_weight;
			}
			Animal animal;
			Pair position = new Pair(py, px);
			if (weight != 0) {
				animal = new Animal(weight, position);
			} else {
				animal = new Animal(position);
			}
			AddAnimal(animal);
		}
	}

	/**
	 * \brief Constructor
	 * \details Mengenerate kebun binatang dengan input dari user
	 * \param w width lebar kebun binatang
	 * \param l length panjang kebun binatang
	 */
	public Zoo(int w, int l){

	}

	/** \brief Display
	 * \details Menampilkan kebun binatang ke layar
	 */
	public void Display(int x1, int y1, int x2, int y2){

	}

	/**
	 * \brief FindAnimal
	 * \details Mengembalikan iterator hewan yang berada di pos
	 *
	 * \param pos posisi Animal saat itu
	 * \return iterator untuk list Animal
	 */
	public ArrayList<Object>::iterator FindAnimal(pair<int,int> pos){

	}

	/** \brief AddAnimal
	 * \details Menambahkan hewan pada kebun binatang
	 * \param animal hewan yang akan ditambahkan
	 */
	public void AddAnimal(Object animal){

	}

	/**
	 * \brief DelAnimal dengan id
	 * \details Menghapus hewan dengan id=_id dan number=_number
	 * \param _id id jenis hewan
	 * \param _number nomor pada jenis hewan tersebut
	 */
	public void DelAnimal(String _id, int _number){

	}

	/**
	 * \brief DelAnimal
	 * \details Menghapus hewan pada posisi x y
	 * \param x posisi pada width
	 * \param y posisi pada length
	 */
	public void DelAnimal(int x, int y){

	}

	/**
	 * \brief GetTotalMeat
	 * \details mengeluarkan total daging yang diperlukan di zoo dalam kilogram
	 * \return Total daging yang dibutuhkan zoo
	 */
	public float GetTotalMeat(){
	    float sum = 0;
	    for (int i = 0; i < animals.size(); i++) {
	        if (GetType(*it) == 'K') {
	            sum += GetWeight(*it) * GetEat(*it);
	        }
	        else if (GetType(*it) == 'O') {
	            sum += 0.5 * GetWeight(*it) * GetEat(*it);
	        }
	    }
	    return sum;
	}

	/**
	 * \brief GetTotalVegetables
	 * \details mengeluarkan total sayur yang diperlukan di zoo dalam kilogram
	 * \return Total sayur yang dibutuhkan zoo
	 */
	public float GetTotalVegetables(){

	}

	/**
	 * \brief MoveAnimal dengan posisi
	 * \details Menggerakkan animal dengan id=_id dan number=_number
	 * \param pos posisi hewan
	 * \param direction 0 untuk ke atas, 1 untuk ke kiri, 2 untuk ke kanan, 3 untuk ke bawah
	 */
	public void MoveAnimal(pair<int,int> pos, int direction){
	    /*
	    list<Pointer>::iterator it = animals.begin();
	    list<Pointer>::iterator e = animals.end();
	    --e;
	    while (GetId(*it) != _id && GetNumber(*it) != _number && it != e) {
	        ++it;
	    }
	    if (GetId(*it) == _id && GetNumber(*it) == _number) {
	        MoveAnimal(GetPos(*it), direction);
	    }
	    */
	}

	/**
	 * \brief MoveAnimal dengan id
	 * \details Menggerakkan animal dengan id=_id dan number=_number ke arah sesuai direction sebanyak 1 langkah jika memungkinkan (tidak melewati sekat)
	 * \param _id jenis hewan
	 * \param _number no number pada jenis hewan
	 * \param direction 0 untuk ke atas, 1 untuk ke kiri, 2 untuk ke kanan, 3 untuk ke bawah
	 */
	public void MoveAnimal(String _id, int _number, int direction){

	}

	/**
	 * \brief MoveAllAnimal
	 * \details Menggerakkan semua hewan secara acak
	 */
	public void MoveAllAnimal(){

	}

	/**
	 * \brief ToggleSekat
	 * \details Membuka/menutup sekat pada posisi i,j ke arah direction jika memungkinkan (tidak membuka ke luar cage)
	 * \param i posisi pada width
	 * \param j posisi pada length
	 * \param direction 0 untuk ke atas, 1 untuk ke kiri, 2 untuk ke kanan, 3 untuk ke bawah
	 */
	public void ToggleSekat(int i, int j, int direction){

	}

	/**
	 * \brief ToggleAllSekat
	 * \details Membuka/menutup semua sekat
	 */
	public void ToggleAllSekat(){

	}

	/**
	 * \brief Melakukan tour pada kebun binatang
	 * \details Jalur tour akan dipilih secara acak
	 * \details Settiap cell yang ada di samping road yang dilalui akan diinteract. Suatu cell adalah bagian dari suatu cage, maka semua binatang pada cage tersebut akan diinteract
	 */
	public void Tour(){

	}

	/**
	 * \brief InteractCage
	 * \details Melakukan interaksi dengan semua hewan yang ada di cage yang sama. Cage memiliki posisi pos dan nomor cage_number
	 * \param pos posisi cage
	 * \param cage_number nomor cage
	 */
	public void InteractCage(pair<int, int> pos, int cage_number){

	}
}
