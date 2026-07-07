package com.sahibinden.elearningdatagenerator;

import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.Random;

public class ELearningDataGenerator {

    public static void main(String[] args) {
        // İngilizce isimler üretsin
        Faker faker = new Faker(new Locale("en"));
        Random rand = new Random();

        // TTL Dosyası için gerekli Prefix (Önek) tanımlamaları
        System.out.println("@prefix : <http://www.example.org/elearning-ontology#> .");
        System.out.println("@prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .");
        System.out.println("@prefix xsd: <http://www.w3.org/2001/XMLSchema#> .\n");

        // 1. Öğrenci Verileri (Students)
        System.out.println("# --- GENERATED STUDENTS ---");
        for (int i = 1; i <= 5; i++) {
            String name = faker.name().fullName();
            String email = name.toLowerCase().replace(" ", ".") + "@student.example.edu";
            
            System.out.println(":Student_Gen" + i + " rdf:type :Student ;");
            System.out.println("    :hasName \"" + name + "\" ;");
            System.out.println("    :hasEmail \"" + email + "\" .\n");
        }

        // 2. Ders Verileri (Courses)
        System.out.println("# --- GENERATED COURSES ---");
        for (int i = 1; i <= 3; i++) {
            String courseCode = "CS-" + faker.number().numberBetween(100, 599);
            String courseTitle = faker.educator().course();
            
            System.out.println(":Course_Gen" + i + " rdf:type :Course ;");
            System.out.println("    :courseCode \"" + courseCode + "\" ;");
            System.out.println("    :courseTitle \"" + courseTitle + "\" .\n");
        }

        // 3. Not Verileri (Grades)
        System.out.println("# --- GENERATED GRADES ---");
        for (int i = 1; i <= 5; i++) {
            float score = 50 + rand.nextFloat() * 50;
            // Noktalı ondalık formatı garantiye almak için US locale kullanıyoruz
            String formattedScore = String.format(Locale.US, "%.1f", score);
            
            System.out.println(":Grade_Gen" + i + " rdf:type :Grade ;");
            // Veri tipini XSD standardına uygun olarak xsd:float formatında bağlıyoruz
            System.out.println("    :score \"" + formattedScore + "\"^^xsd:float .\n");
        }
    }
}
