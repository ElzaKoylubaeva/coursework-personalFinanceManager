import ru.koylubaevaem.netology.model.Purchase;
import ru.koylubaevaem.netology.model.Response;
import ru.koylubaevaem.netology.service.FileService;
import ru.koylubaevaem.netology.service.MappingService;
import ru.koylubaevaem.netology.service.StorageService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Main {

    public static final int PORT = 8989;

    public static void main(String[] args) throws IOException {
        File binStatisticFile = new File("data.bin");
        FileService fileService = new FileService();
        Map<String, String> item2cat = fileService.readFile(new File("categories.tsv"));
        System.out.println(item2cat);

        StorageService storageService = new StorageService();
        storageService.setItem2Category(item2cat);

        if (binStatisticFile.exists()) {
            try {
                Map<String, Long> cat2Sum = fileService.readBinData(binStatisticFile);
                storageService.setCategory2Sum(cat2Sum);
            } catch (ClassNotFoundException ignore) {}
        }

        MappingService mappingService = new MappingService();

        System.out.println("Starting server...");
        System.out.println("Categories: " + storageService.getCategory2Sum());
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started...");
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream())) {
                    // обработка одного подключения
                    String json = in.readLine();
                    Purchase purchase = mappingService.deserialize(json);
                    String category = storageService.getCategory(purchase.getTitle());
                    storageService.updateCategorySum(category, purchase.getSum());
                    Response response = storageService.getMaxCategory();
                    String result = mappingService.serialize(response);
                    out.println(result);
                    fileService.saveBinData(binStatisticFile, storageService.getCategory2Sum());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
