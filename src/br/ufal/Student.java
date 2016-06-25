package br.ufal;

public class Student extends User {
	public boolean allocateResource(Resource resource){
		System.out.println("Este usuário não possui permissões para alocar um recurso!");
		return false;
	}
}
