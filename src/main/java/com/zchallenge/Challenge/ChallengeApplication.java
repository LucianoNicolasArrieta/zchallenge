package com.zchallenge.Challenge;


public class ChallengeApplication {

	public static void main(String[] args) {
		// Ejemplo dado
		FileSystem fs = new FileSystem("/user/aplicacion");
		System.out.println(fs.pwd());

		fs.mkdir("files");
		fs.cd("files");
		System.out.println(fs.pwd());

		fs.cd("..");
		System.out.println(fs.pwd());

		fs.cd("files");
		fs.touch("hello.txt");
		System.out.println(fs.ls());

		fs.mkdir("documents");
		System.out.println(fs.ls());

		fs.cd("documents");
		System.out.println(fs.pwd());
//
//		fs.cd("..");
//		fs.cd("..");
//		fs.mkdir("files/documents/2025");
//
//		fs.mkdir("prueba");
//		System.out.println(fs.ls());
//
//		fs.cd("files");
//		fs.cd("documents");
//		fs.cd("2025");
//		System.out.println(fs.pwd());
//
	}

}
