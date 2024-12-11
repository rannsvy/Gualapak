package model;

import java.util.List;
import model.User;
import view.UserView;
import controller.UserController;

public class Admin extends User {

    public Admin(String namaToko, String password) {
        super(namaToko, password);
    }

    public String generateId(String kategori) {
        String kategoriPrefix = "";
        switch (kategori) {
            case "Elektronik" -> kategoriPrefix = "01";
            case "Pakaian" -> kategoriPrefix = "02";
            case "Peralatan Rumah Tangga" -> kategoriPrefix = "03";
            case "Lainnya" -> kategoriPrefix = "04";
        }
        return kategoriPrefix + (int) (Math.random() * 10000);
    }
}
