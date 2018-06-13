package com.mycompany.testrest;

import com.service_rest.application.modelo.SendUser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.reflections.util.Utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aco-ec-029
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        try {
            List<SendUser> users = new ArrayList<SendUser>();

            Reader usersFile = new FileReader("/home/aco-ec-029/Documents/Usuarios.csv");
//            Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader("ID", "Fabricante", "RSSI", "fecha").parse(devices);
            final CSVParser records = new CSVParser(usersFile, CSVFormat.EXCEL.withHeader().withDelimiter(';'));

            try {
                for (CSVRecord record : records) {
                    final String username = record.get("username");
                    final String password = record.get("password");
                    final String roleName = record.get("rolename");
                    final String roleDescription = record.get("roleDescription");
                    final String addressStreet = record.get("addressStreet");
                    final String addressIntNumber = record.get("addressIntNumber");
                    final String addressExtNumber = record.get("addressExtNumber");
                    final String addressNeighbourhood = record.get("addressNeighbourhood");
                    if (!Utils.isEmpty(username)) {
                        users.add(new SendUser(username, password, roleName, roleDescription, addressStreet, addressIntNumber, addressExtNumber, addressNeighbourhood));
                    }

                }
            } finally {
                records.close();
                usersFile.close();
            }
            SendUser addUser = new SendUser();
            addUser.setUsername("carlos.cruz");
            addUser.setPassword("disidsnbuf");
            addUser.setRoleName("admin");
            addUser.setRoleDescription("administrador");

            String userNameRandom = "carlos.hector";
            addUser.setUsername(userNameRandom);
            
            Boolean contains = users.contains(addUser);
            System.out.println("Contains: " + contains);
            while (contains) {
                userNameRandom = RandomStringUtils.randomAlphabetic(12);
                addUser.setUsername(userNameRandom);
                
                contains = users.contains(addUser);
            }
            
//            for (SendUser user : users) {
//                System.out.println("username: " + user.getUsername());
//                if (user.getUsername().equals(UserNameRandom)) {
//                    UserNameRandom = RandomStringUtils.randomAlphabetic(12);
//
//                }
//                
//                System.out.println("Username: " + user.getUsername() + " Password: " + user.getPassword() + " Role name: "
//                        + user.getRoleName() + " Role description: " + user.getRoleDescription() + " Street: " + user.getAddressStreet());
//
//            }
//            System.out.println("Tamaño: " + users.size());
            System.out.println("Usuario a agregar: " + ReflectionToStringBuilder.toString(addUser));
            System.out.println("Usuario a agregar: " + 1518100258000L/1000);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
