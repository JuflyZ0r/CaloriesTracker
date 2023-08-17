package dao;

import dao.impl.ProductFileDAO;
import model.Product;
import repository.IMPL.ProductFileRepository;
import service.IMPL.ProductServiceImpl;

import java.util.List;
import java.util.Objects;

public class Configuration {
    // Список всіх файлів
    private String outFileAddress = "D:/out.txt";
    private String productEatFileAddress = "D:/productEat.txt";

    private String caloriesPerDayFileAddress = "D:/caloriesPerDay.txt";

    // Залежності

    ProductFileRepository productFileRepository = new ProductFileRepository();
    ProductServiceImpl productService = new ProductServiceImpl();

    ProductFileDAO productFileDAO = new ProductFileDAO();

    // Лісти

    List<String> stringList = productFileRepository.getEatenProductDuringDay();

    String repositoryReturnLine = productFileDAO.readFromFileRepository(outFileAddress);

    List<Product> productList = productFileRepository.getProductInfoFromFile(repositoryReturnLine);



    public Configuration() {
    }


    public String getOutFileAddress() {
        return outFileAddress;
    }

    public void setOutFileAddress(String outFileAddress) {
        this.outFileAddress = outFileAddress;
    }

    public String getProductEatFileAddress() {
        return productEatFileAddress;
    }

    public void setProductEatFileAddress(String productEatFileAddress) {
        this.productEatFileAddress = productEatFileAddress;
    }

    public String getCaloriesPerDayFileAddress() {
        return caloriesPerDayFileAddress;
    }

    public void setCaloriesPerDayFileAddress(String caloriesPerDayFileAddress) {
        this.caloriesPerDayFileAddress = caloriesPerDayFileAddress;
    }

    public ProductFileRepository getProductFileRepository() {
        return productFileRepository;
    }

    public void setProductFileRepository(ProductFileRepository productFileRepository) {
        this.productFileRepository = productFileRepository;
    }

    public ProductServiceImpl getProductService() {
        return productService;
    }

    public void setProductService(ProductServiceImpl productService) {
        this.productService = productService;
    }

    public ProductFileDAO getProductFileDAO() {
        return productFileDAO;
    }

    public void setProductFileDAO(ProductFileDAO productFileDAO) {
        this.productFileDAO = productFileDAO;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public String getRepositoryReturnLine() {
        return repositoryReturnLine;
    }

    public void setRepositoryReturnLine(String repositoryReturnLine) {
        this.repositoryReturnLine = repositoryReturnLine;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuration that = (Configuration) o;
        return Objects.equals(outFileAddress, that.outFileAddress) && Objects.equals(productEatFileAddress, that.productEatFileAddress) && Objects.equals(caloriesPerDayFileAddress, that.caloriesPerDayFileAddress) && Objects.equals(productFileRepository, that.productFileRepository) && Objects.equals(productService, that.productService) && Objects.equals(productFileDAO, that.productFileDAO) && Objects.equals(stringList, that.stringList) && Objects.equals(repositoryReturnLine, that.repositoryReturnLine) && Objects.equals(productList, that.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(outFileAddress, productEatFileAddress, caloriesPerDayFileAddress, productFileRepository, productService, productFileDAO, stringList, repositoryReturnLine, productList);
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "outFileAddress='" + outFileAddress + '\'' +
                ", productEatFileAddress='" + productEatFileAddress + '\'' +
                ", caloriesPerDayFileAddress='" + caloriesPerDayFileAddress + '\'' +
                ", productFileRepository=" + productFileRepository +
                ", productService=" + productService +
                ", productFileDAO=" + productFileDAO +
                ", stringList=" + stringList +
                ", repositoryReturnLine='" + repositoryReturnLine + '\'' +
                ", productList=" + productList +
                '}';
    }
}
