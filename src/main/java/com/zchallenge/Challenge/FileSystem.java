package com.zchallenge.Challenge;

import java.util.List;
import java.util.stream.Collectors;

public class FileSystem {

    private Directorio directorioActual;

    public FileSystem(String root) {
        this.directorioActual = new Directorio(root, null);
    }

    public void mkdir(String nombre) {
        if (!directorioActual.getHijos().stream()
                .filter(hijo -> hijo.getClass().equals(Directorio.class))
                .map(hijo -> hijo.getNombre())
                .toList().contains(nombre)) {
            Directorio nuevoDirectorio = new Directorio(nombre, directorioActual);
            directorioActual.getHijos().add(nuevoDirectorio);
        } else {
            throw new RuntimeException("Ya existe un directorio con ese nombre");
        }
    }

    public void cd(String dirName) {
        if (dirName.equals("..")) {
            directorioActual = directorioActual.getPadre();
        } else {
            EntidadFileSystem directorioAMoverse = directorioActual.getHijos().stream()
                    .filter(hijo -> hijo.getNombre().equals(dirName) &&
                            hijo.getClass().equals(Directorio.class))
                    .findFirst().orElse(null);
            if (directorioAMoverse != null) {
                directorioActual = (Directorio) directorioAMoverse;
            } else {
                throw new RuntimeException("El directorio especificado no existe");
            }
        }
    }

    public void touch(String fileName) {
        if (nombreArchivoValido(fileName)) {
            Archivo nuevoArchivo = new Archivo(fileName);
            directorioActual.getHijos().add(nuevoArchivo);
        } else {
            throw new RuntimeException("El nombre del archivo ya existe");
        }
    }

    public List<String> ls() {
        return directorioActual.getHijos().stream().map(hijo -> hijo.getNombre()).collect(Collectors.toList());
    }

    public String pwd() {
        String pathActual = directorioActual.getPath();
        return pathActual;
    }

    private boolean nombreArchivoValido(String nombre) {
        return directorioActual.getHijos().stream()
                .filter(hijo -> hijo.getClass().equals(Archivo.class)
                        && hijo.getNombre().equals(nombre))
                .toList().isEmpty();

        // Faltarian verificaciones de caracteres especiales en el nombre del archivo.
    }
}
