package org.example.DTOs;

          id INT PRIMARY KEY,
          name VARCHAR(50),
          team VARCHAR(50),
          height_in_cm INT,
          weight_in_kg INT,
          points_per_game FLOAT


public class Players {

    private int id;
    private String firstname;
    private String lastname;
    private int height_in_cm;
    private int weight_in_kg ;
    private double points_per_game;
}
