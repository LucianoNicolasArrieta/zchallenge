package com.zchallenge.Challenge;

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
        }
        EntidadFileSystem directorioAMoverse = directorioActual.getHijos().stream()
                .filter(hijo -> hijo.getNombre().equals(dirName) &&
                        hijo.getClass().equals(Directorio.class))
                .toList().get(0);
        if (directorioAMoverse != null) {
            directorioActual = (Directorio) directorioAMoverse;
        } else {
            throw new RuntimeException("El directorio especificado no existe");
        }
    }

    public void touch(String fileName) {
        // Si es valido, lo crea en el directorio donde se encuentra
    }

    public void ls() {
        // Lista archivos y carpetas en el directorio actual
    }

    public void pwd() {
        // Muestra el directorio/path actual.
    }
}
