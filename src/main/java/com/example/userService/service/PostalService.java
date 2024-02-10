package com.example.userService.service;

import com.example.userService.model.Postal;
import com.example.userService.repository.PostalRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@PropertySource(value = "classpath:application.properties")
@Service
public class PostalService {
    @Value("${api.postal.apiKey}")
    private String apiKey;

    private PostalRepository repo;
    private PostalService(PostalRepository repo){
        this.repo = repo;
    }

    public List<Postal> getAll(){
        return repo.findAll();
    }

    public Postal getPostal(Long id){
        return repo.findById(id).get();
    }

    public Postal savePostal(Postal postal){
        return repo.save(postal);
    }

    public Postal apiLookup(Long zip) throws IOException {
        URL url = new URL("https://app.zipcodebase.com/api/v1/search?apikey="+ apiKey +"&country=US&codes="+zip);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if(responseCode == HttpURLConnection.HTTP_OK){
            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(connection.getInputStream());

            while (scanner.hasNext()){
                sb.append(scanner.nextLine());
            }

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(sb.toString());
            jsonNode = jsonNode.path("results").path(zip.toString()).get(0);
            Postal info = objectMapper.readValue(jsonNode.toString(), Postal.class);

            return info;
        }
        else throw new ConnectException();
    }

    public Optional<Postal> checkExistence(Long zip){
        Optional<Postal> optionalPostal= repo.findById(zip);

        return optionalPostal;

    }
}
