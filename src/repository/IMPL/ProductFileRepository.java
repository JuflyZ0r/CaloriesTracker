package repository.IMPL;

import dao.GetProductInfoFromFile;
import model.Nutrition;
import model.Product;
import repository.ProductRepository;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ProductFileRepository implements ProductRepository {
    GetProductInfoFromFile getProductInfoFromFile = new GetProductInfoFromFile();
    @Override
    public void saveToFileRepository(String data, String address) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(address);
        byte[] array = data .getBytes();
        for (byte b : array){
            fileOutputStream.write(b);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    @Override
    public String readFromFileRepository(String address) {
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(address))) {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getProductInfoFromFile.getProductInfoFromFile(line);
        return line;
    }
}
