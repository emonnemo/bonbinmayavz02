/* File     : Driver.java */
/* Author     : Andika Kusuma dan Reinaldo Ignatius Wijaya */

package zoo;

import animal.Animal;
import cell.Cell;
import pair.Pair;
import java.io.FileInputStream;
import java.util.ArrayList;

import java.util.*;

/**
 * \brief Class Zoo
 * \details Kelas Zoo yang berisi kebun binatang itu sendiri beserta hewan-hewannya
 */
public class Zoo {
    private int width;
    /**
     * < dimensi zoo; jumlah baris
     */
    private int length;
    /**
     * < dimensi zoo; jumlah kolom
     */
    private Cell[][] cells;
    /**
     * < matriks Cell yang dimiliki zoo
     */
    private ArrayList<Animal> animals;
    /**
     * < daftar Animals yang ada dalam zoo
     */
    private int[][] cage_map;
    /**
     * < matriks penanda nomor cage dalam zoo
     */
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
                        int array_i[];
                        array_i = new int[4];
                        int array_j[];
                        array_j = new int[4];
                        for (int k = 0; k < 4; ++k) {
                            array_i[k] = i;
                            array_j[k] = j;
                        }
                        boolean cek = true;
                        cage_map[i][j] = counter;
                        Random random = new Random();
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
    public Zoo(int w, int l) {

    }

    /**
     * \brief Display
     * \details Menampilkan kebun binatang ke layar
     */
    public void Display(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; ++i) {
            for (int j = y1; j <= y2; ++j) {
                System.out.print(cells[i][j].GetSymbol());
            }
            System.out.println();
        }
    }

    /**
     * \brief FindAnimal
     * \details Mengembalikan iterator hewan yang berada di pos
     * <p>
     * \param pos posisi Animal saat itu
     * \return int untuk indeks arraylist animals
     */
    public int FindAnimal(Pair pos) {
        int i = 0;
        while (animals.get(i).GetPos() != pos && i < animals.size() - 1) {
            ++i;
        }
        if (animals.get(i).GetPos() == pos) {
            return i;
        }
        return animals.size();
    }

    /**
     * \brief AddAnimal
     * \details Menambahkan hewan pada kebun binatang
     * \param animals hewan yang akan ditambahkan
     */
    public void AddAnimal(Animal animal) {
        int posx = animal.GetPos().first;
        int posy = animal.GetPos().second;
        if (posx >= 0 && posx < width && posy >= 0 && posy < length) {
            int cage = cage_map[posx][posy];
            // cek if habitat dlu
            Set<Character> hab = animal.GetHabitat();
            Set<String> compability = animal.GetCompatible();
            Pair pos;
            pos = new Pair(posx, posy);
            if (FindAnimal(pos) == animals.size()) {
                if (hab.contains(cells[posx][posy].GetSymbol())) {
                    boolean compatible = true;
                    // cek apakah ada hewan yang tidak kompatible dengan hewan animal
                    int count = 0; // count animal yang ada di cage yang sama
                    for (int i = 0; i < animals.size(); i++) {
                        if (cage == cage_map[animals.get(i).GetPos().first][animals.get(i).GetPos().second]) {
                            count++;
                            if (compability.contains(animal.GetId())) {
                                compatible = false;
                            }
                        }
                    }
                    int max = 0;
                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < length; j++) {
                            if (cage_map[i][j] == cage) {
                                max++;
                            }
                        }
                    }
                    if (0.3 * max >= (count + 1) && compatible) { // masih muat cagenya
                        animals.add(animal);
                        cells[posx][posy].SetSymbol(animal.GetLegend());
                    }
                }
            }
        }
    }

    /**
     * \brief DelAnimal dengan id
     * \details Menghapus hewan dengan id=_id dan number=_number
     * \param _id id jenis hewan
     * \param _number nomor pada jenis hewan tersebut
     */
    public void DelAnimal(String _id, int _number) {
        int i = 0;
        while (animals.get(i).GetId().equals(_id) && animals.get(i).GetNumber() != _number && i < animals.size() - 1) {
            ++i;
        }
        if (animals.get(i).GetId() == _id && animals.get(i).GetNumber() == _number) {
            animals.remove(i);
        }
        int posx = animals.get(i).GetPos().first;
        int posy = animals.get(i).GetPos().second;
        cells[posx][posy].SetSymbol(cells[posx][posy].GetInitSymbol());
    }

    /**
     * \brief DelAnimal
     * \details Menghapus hewan pada posisi x y
     * \param x posisi pada width
     * \param y posisi pada length
     */
    public void DelAnimal(int x, int y) {
        Pair pos;
        pos = new Pair(x, y);
        if (FindAnimal(pos) != animals.size()) {
            int idx = FindAnimal(pos);
            DelAnimal(animals.get(idx).GetId(), animals.get(idx).GetNumber());
        }
    }

    /**
     * \brief GetTotalMeat
     * \details mengeluarkan total daging yang diperlukan di zoo dalam kilogram
     * \return Total daging yang dibutuhkan zoo
     */
    public float GetTotalMeat() {
        float sum = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).GetType() == 'K') {
                sum += animals.get(i).GetWeight() * animals.get(i).GetEat();
            } else if (animals.get(i).GetType() == 'O') {
                sum += 0.5 * animals.get(i).GetWeight() * animals.get(i).GetEat();
            }
        }
        return sum;
    }

    /**
     * \brief GetTotalVegetables
     * \details mengeluarkan total sayur yang diperlukan di zoo dalam kilogram
     * \return Total sayur yang dibutuhkan zoo
     */
    public float GetTotalVegetables() {
        float sum = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).GetType() == 'H') {
                sum += animals.get(i).GetWeight() * animals.get(i).GetEat();
            } else if (animals.get(i).GetType() == 'O') {
                sum += 0.5 * animals.get(i).GetWeight() * animals.get(i).GetEat();
            }
        }
        return sum;
    }

    /**
     * \brief MoveAnimal dengan posisi
     * \details Menggerakkan animals dengan id=_id dan number=_number
     * \param pos posisi hewan
     * \param direction 0 untuk ke atas, 1 untuk ke kiri, 2 untuk ke kanan, 3 untuk ke bawah
     */
    public void MoveAnimal(Pair pos, int direction) {
        int idx = FindAnimal(pos);
        if (idx != animals.size()) {
            if (cells[pos.first][pos.second].GetSekat(direction)) {
                boolean valid = false;
                int i = pos.first, j = pos.second;
                switch (direction) {
                    case 0:
                        if (i - 1 >= 0) {
                            valid = true;
                            --i;
                        }
                        break;
                    case 1:
                        if (j - 1 >= 0) {
                            valid = true;
                            --j;
                        }
                        break;
                    case 2:
                        if (j + 1 < length) {
                            valid = true;
                            ++j;
                        }
                        break;
                    case 3:
                        if (i + 1 < width) {
                            valid = true;
                            ++i;
                        }
                        break;
                }
                if (valid) {
                    Pair finalPos;
                    finalPos = new Pair(i, j);
                    if (FindAnimal(finalPos) == animals.size()) {
                        animals.get(idx).Move(direction);
                        cells[pos.first][pos.second].
                                SetSymbol(cells[pos.first][pos.second].GetInitSymbol());
                        cells[animals.get(idx).GetPos().first][animals.get(idx).GetPos().second].
                                SetSymbol(animals.get(idx).GetLegend());
                    }
                }
            }
        }
    }

    /**
     * \brief MoveAnimal dengan id
     * \details Menggerakkan animals dengan id=_id dan number=_number ke arah sesuai direction sebanyak 1 langkah jika memungkinkan (tidak melewati sekat)
     * \param _id jenis hewan
     * \param _number no number pada jenis hewan
     * \param direction 0 untuk ke atas, 1 untuk ke kiri, 2 untuk ke kanan, 3 untuk ke bawah
     */
    public void MoveAnimal(String _id, int _number, int direction) {
        int i = 0;
        while (animals.get(i).GetId() != _id && animals.get(i).GetNumber() != _number && i < animals.size() - 1) {
            ++i;
        }
        if (animals.get(i).GetId() == _id && animals.get(i).GetNumber() == _number) {
            MoveAnimal(animals.get(i).GetPos(), direction);
        }
    }

    /**
     * \brief MoveAllAnimal
     * \details Menggerakkan semua hewan secara acak
     */
    public void MoveAllAnimal() {
        Random random = new Random();
        for (int i = 0; i < animals.size(); i++) {
            MoveAnimal(animals.get(i).GetPos(), random.nextInt(4));
        }
    }

    /**
     * \brief ToggleSekat
     * \details Membuka/menutup sekat pada posisi i,j ke arah direction jika memungkinkan (tidak membuka ke luar cage)
     * \param i posisi pada width
     * \param j posisi pada length
     * \param direction 0 untuk ke atas, 1 untuk ke kiri, 2 untuk ke kanan, 3 untuk ke bawah
     */
    public void ToggleSekat(int i, int j, int direction) {
        if (i >= 0 && i < width && j >= 0 && j < length) {
            char c = cells[i][j].GetInitSymbol();
            if (c == 'W' || c == 'L' || c == 'A') {
                switch (direction) {
                    case 0:
                        if (i - 1 >= 0) {
                            if (cage_map[i - 1][j] == cage_map[i][j]) {
                                cells[i][j].ToggleSekat(0);
                                cells[i - 1][j].ToggleSekat(3);
                            }
                        }
                        break;
                    case 1:
                        if (j - 1 >= 0) {
                            if (cage_map[i][j - 1] == cage_map[i][j]) {
                                cells[i][j].ToggleSekat(1);
                                cells[i][j - 1].ToggleSekat(2);
                            }
                        }
                        break;
                    case 2:
                        if (j + 1 < length) {
                            if (cage_map[i][j + 1] == cage_map[i][j]) {
                                cells[i][j].ToggleSekat(2);
                                cells[i][j + 1].ToggleSekat(1);
                            }
                        }
                        break;
                    case 3:
                        if (i + 1 < width) {
                            if (cage_map[i + 1][j] == cage_map[i][j]) {
                                cells[i][j].ToggleSekat(3);
                                cells[i + 1][j].ToggleSekat(0);
                            }
                        }
                        break;
                }
            }
        }
    }

    /**
     * \brief ToggleAllSekat
     * \details Membuka/menutup semua sekat
     */
    public void ToggleAllSekat() {
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < length; ++j) {
                for (int k = 0; k < 2; ++k) {
                    ToggleSekat(i, j, k);
                }
            }
        }
    }

    /**
     * \brief Melakukan tour pada kebun binatang
     * \details Jalur tour akan dipilih secara acak
     * \details Settiap cell yang ada di samping road yang dilalui akan diinteract. Suatu cell adalah bagian dari suatu cage, maka semua binatang pada cage tersebut akan diinteract
     */
    public void Tour() {
        Set<Pair> entrance;
        entrance = new HashSet<Pair>();
        boolean vis[][];
        vis = new boolean[width][length];
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < length; ++j) {
                if (cells[i][j].GetSymbol() == 'N') {
                    Pair pairInput;
                    pairInput = new Pair(i,j);
                    entrance.add(pairInput);
                }
                vis[i][j] = false;
            }
        }
        Random random = new Random();
        int selection = random.nextInt(entrance.size());
        Deque<Pair> dstack;
        dstack = new ArrayDeque<Pair>();
        ArrayList<Integer> route;
        route = new ArrayList<Integer>();
        List<Pair> listEntrance;
        listEntrance = new ArrayList<Pair>(entrance);
        int posi = listEntrance.get(selection).first, posj = listEntrance.get(selection).second;
        dstack.push(listEntrance.get(selection));
        boolean found = false;
        while (!found) {
            int i = dstack.peek().first, j = dstack.peek().second;
            vis[i][j] = true;
            if (cells[i][j].GetSymbol() == 'X') {
                found = true;
                route.remove((Integer)4);
            } else {
                char c;
                Set<Integer> choice;
                choice = new HashSet<Integer>();
                if (i-1 >= 0) {
                    c = cells[i-1][j].GetSymbol();
                    if (c == 'r' || c == 'X') {
                        if (!vis[i-1][j]) {
                            choice.add(0);
                        }
                    }
                }
                if (j - 1 >= 0) {
                    c = cells[i][j-1].GetSymbol();
                    if (c == 'r' || c == 'X') {
                        if (!vis[i][j-1]) {
                            choice.add(1);
                        }
                    }
                }
                if (j + 1 < length) {
                    c = cells[i][j+1].GetSymbol();
                    if (c == 'r' || c == 'X') {
                        if (!vis[i][j+1]) {
                            choice.add(2);
                        }
                    }
                }
                if (i+1 < width) {
                    c = cells[i+1][j].GetSymbol();
                    if (c == 'r' || c == 'X') {
                        if (!vis[i+1][j]) {
                            choice.add(3);
                        }
                    }
                }
                if (choice.size() > 0) {
                    selection = random.nextInt(choice.size());
                    List<Integer> listChoice;
                    listChoice = new ArrayList<Integer>(choice);
                    route.remove(listChoice.get(selection));
                    Pair pairInput;
                    switch(listChoice.get(selection)) {
                        case 0:
                            pairInput = new Pair((i-1), j);
                            dstack.push(pairInput);
                            break;
                        case 1:
                            pairInput = new Pair(i, (j-1));
                            dstack.push(pairInput);
                            break;
                        case 2:
                            pairInput = new Pair(i, (j+1));
                            dstack.push(pairInput);
                            break;
                        case 3:
                            pairInput = new Pair((i+1), j);
                            dstack.push(pairInput);
                            break;
                    }
                } else {
                    dstack.pop();
                    route.remove(route.size()-1);
                }
            }
        }
        boolean VisCage[];
        VisCage = new boolean[cage_nb];
        for (int i = 0; i < cage_nb; ++i) {
            VisCage[i] = false;
        }
        while (!route.isEmpty()) {
            Pair pairPos;
            if (posi - 1 >= 0) {
                char c = cells[posi-1][posj].GetInitSymbol();
                if (c == 'P' || c == 'R') {
                    cells[posi-1][posj].Interact();
                } else if (c == 'W' || c == 'L' || c == 'A') {
                    if (!VisCage[cage_map[posi-1][posj]]) {
                        pairPos = new Pair((posi-1),posj);
                        InteractCage(pairPos, cage_map[posi-1][posj]);
                        VisCage[cage_map[posi-1][posj]] = true;
                    }
                }
            }
            if (posj - 1 >= 0) {
                char c = cells[posi][posj-1].GetInitSymbol();
                if (c == 'P' || c == 'R') {
                    cells[posi][posj-1].Interact();
                } else if (c == 'W' || c == 'L' || c == 'A') {
                    if (!VisCage[cage_map[posi][posj-1]]) {
                        pairPos = new Pair(posi,(posj-1));
                        InteractCage(pairPos, cage_map[posi][posj-1]);
                        VisCage[cage_map[posi][posj-1]] = true;
                    }
                }
            }
            if (posj + 1 < length) {
                char c = cells[posi][posj+1].GetInitSymbol();
                if (c == 'P' || c == 'R') {
                    cells[posi][posj+1].Interact();
                } else if (c == 'W' || c == 'L' || c == 'A') {
                    if (!VisCage[cage_map[posi][posj+1]]) {
                        pairPos = new Pair(posi,(posj+1));
                        InteractCage(pairPos, cage_map[posi][posj+1]);
                        VisCage[cage_map[posi][posj+1]] = true;
                    }
                }
            }
            if (posi + 1 < width) {
                char c = cells[posi+1][posj].GetInitSymbol();
                if (c == 'P' || c == 'R') {
                    cells[posi+1][posj].Interact();
                } else if (c == 'W' || c == 'L' || c == 'A') {
                    if (!VisCage[cage_map[posi+1][posj]]) {
                        pairPos = new Pair((posi+1),posj);
                        InteractCage(pairPos, cage_map[posi+1][posj]);
                        VisCage[cage_map[posi+1][posj]] = true;
                    }
                }
            }
            switch (route.get(0)) {
                case 0:
                    --posi;
                    break;
                case 1:
                    --posj;
                    break;
                case 2:
                    ++posj;
                    break;
                case 3:
                    ++posi;
                    break;
            }
            route.remove(0);
        }
    }

    /**
     * \brief InteractCage
     * \details Melakukan interaksi dengan semua hewan yang ada di cage yang sama. Cage memiliki posisi pos dan nomor cage_number
     * \param pos posisi cage
     * \param cage_number nomor cage
     */
    public void InteractCage(Pair pos, int cage_number) {
        boolean Vis[][];
        Vis = new boolean[width][length];
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < length; ++j) {
                Vis[i][j] = false;
            }
        }
        Queue<Pair> bqueue;
        bqueue = new LinkedList<Pair>();
        bqueue.add(pos);
        Vis[pos.first][pos.second] = true;
        while (bqueue.peek() != null) {
            int i = bqueue.element().first, j = bqueue.element().second;
            bqueue.remove();
            Pair pair;
            pair = new Pair(i, j);
            if (FindAnimal(pair) != animals.size()) {
                animals.get(FindAnimal(pair)).Interact();
            }
            if (i - 1 >= 0) {
                if (cage_map[i - 1][j] == cage_number) {
                    if (!Vis[i - 1][j]) {
                        Pair pairInput;
                        pairInput = new Pair((i - 1), j);
                        bqueue.add(pairInput);
                        Vis[i - 1][j] = true;
                    }
                }
            }
            if (j - 1 >= 0) {
                if (cage_map[i][j - 1] == cage_number) {
                    if (!Vis[i][j - 1]) {
                        Pair pairInput;
                        pairInput = new Pair(i, (j - 1));
                        bqueue.add(pairInput);
                        Vis[i][j - 1] = true;
                    }
                }
            }
            if (j + 1 < length) {
                if (cage_map[i][j + 1] == cage_number) {
                    if (!Vis[i][j + 1]) {
                        Pair pairInput;
                        pairInput = new Pair(i, (j + 1));
                        bqueue.add(pairInput);
                        Vis[i][j + 1] = true;
                    }
                }
            }
            if (i + 1 < width) {
                if (cage_map[i + 1][j] == cage_number) {
                    if (!Vis[i + 1][j]) {
                        Pair pairInput;
                        pairInput = new Pair((i + 1), j);
                        bqueue.add(pairInput);
                        Vis[i + 1][j] = true;
                    }
                }
            }
        }
    }
}
