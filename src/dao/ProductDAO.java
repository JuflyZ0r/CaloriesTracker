package dao;

import java.io.IOException;

public interface ProductDAO {

    void saveToFileDAO(String data, String address) throws IOException;

    String readFromFileRepository(String address);

}
