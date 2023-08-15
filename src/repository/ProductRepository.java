package repository;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ProductRepository {

    void saveToFileRepository(String data,String address) throws IOException;

    String readFromFileRepository(String address);

}
