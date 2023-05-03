package org.example.Server;

import org.example.DAOs.MySqlArenaDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {
    private int port;
    private Server server;

    @BeforeEach
    void setUp() {
        port = 8078;
        server = new Server();
    }


    @Test
    void main() {
    }

    @Test
    void start() {
    }
}