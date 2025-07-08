package com.zchallenge.Challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class FileSystemTest {
    private FileSystem fileSystem;

    @BeforeEach
    public void setUp() {
        fileSystem = new FileSystem("root");
    }

    @Test
    public void testCrearDirectorio() {
        fileSystem.mkdir("files");

        List<String> ls = fileSystem.ls();
        Assertions.assertTrue(ls.contains("files"));
    }

    @Test
    public void testCrearDirectorioQueYaExiste() {
        fileSystem.mkdir("files");

        Assertions.assertThrows(RuntimeException.class, () -> fileSystem.mkdir("files"));
    }

    @Test
    public void testMostrarPath() {
        String path = fileSystem.pwd();

        Assertions.assertEquals("root", path);
    }

    @Test
    public void testMoverseADirectorio() {
        fileSystem.mkdir("files");
        fileSystem.cd("files");
        String pathActual = fileSystem.pwd();

        Assertions.assertEquals("root/files", pathActual);
    }

    @Test
    public void testVolverADirectorioPadre() {
        fileSystem.mkdir("files");
        fileSystem.cd("files");
        fileSystem.cd("..");

        Assertions.assertEquals("root", fileSystem.pwd());
    }

    @Test
    public void testMoverseADirectorioInexistente() {
        fileSystem.mkdir("files");

        Assertions.assertThrows(RuntimeException.class, () -> fileSystem.cd("documents"));
    }

    @Test
    public void testCrearArchivo() {
        fileSystem.touch("hello.txt");

        List<String> ls = fileSystem.ls();
        Assertions.assertTrue(ls.contains("hello.txt"));
    }

    @Test
    public void testCrearUnArchivoQueYaExiste() {
        fileSystem.touch("hello.txt");

        Assertions.assertThrows(RuntimeException.class, () -> fileSystem.touch("hello.txt"));
    }
}
