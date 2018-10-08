package local.model;

import local.exception.ClienteException;

import javax.validation.constraints.Size;

public class Cliente {


	private String nome;
	
	public Cliente() {}
	
	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
                String[] partes = nome.split(" ");
                int tamanho = nome.length();
                if(nome == null){
			throw new ClienteException("Nome é um campo obrigatório");
		}
                else if(partes.length <= 1){
                    throw new ClienteException("Nome do cadastro deve possuir pelo menos dois nomes");
                }	
                else if (tamanho < 2 || tamanho > 99){
			throw new ClienteException("O nome do cliente deve possuir entre 2 e 99 caracteres");
		}
                else if(!nome.matches("[-ZàèìòùÀÈÌÒÙáéíóúýÁÉÍÓÚÝâêîôûÂÊÎÔÛãñõÃçÇ]+")){
			throw new ClienteException("Números e símbolos não são permitidos");
		}
                
                this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}