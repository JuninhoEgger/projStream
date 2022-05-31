package main;

import entities.ProductEntity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\products.txt"))) {

            List<ProductEntity> products = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                products.add(new ProductEntity(fields[0], parseDouble(fields[1])));
                line = br.readLine();
            }

            double average = products.stream()
                    .map(p -> p.getPrice()) //GERA NOVO STREAM COM O PREÇO DOS PRODUTOS
                    .reduce(0.0, (x, y) -> x + y) / products.size();
            showMessageDialog(null, "AVERAGE PRICE: R$ " + format("%.2f", average));

            Comparator<String> comparator = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> names = products.stream()
                    .filter(p -> p.getPrice() < average)
                    .map(p -> p.getName())
                    .sorted(comparator.reversed())
                    .collect(Collectors.toList());

            StringBuilder response = new StringBuilder("NOMES\n");
            names.forEach(name -> response.append(name).append("\n"));
            showMessageDialog(null, response);

        } catch (IOException e) {
            showMessageDialog(null, e.getMessage());
        }

    }
}
