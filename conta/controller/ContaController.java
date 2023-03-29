package conta.controller;
import conta.model.Conta;
import conta.repository.ContaRepository;

import java.util.ArrayList;

public class ContaController implements ContaRepository {
		// criando o "banco de dados":
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
	
	
	 // Procurar Conta por numero
     
    @Override
    public void procurarPorNumero(int numero) {
        var conta = buscarNaCollection(numero);
		
		if (conta != null)
			conta.visualizar();
		else
			System.out.println("\nA Conta número: " + numero + " não foi encontrada!");
    }
    

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA conta numero: "+ conta.getNumero() +" foi criada com sucesso!");
		
	}
	

	/**
     * Atualizar dados da Conta
     * */
    @Override
    public void atualizar(Conta conta) {
        var buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\nA Conta numero: " + conta.getNumero() + " foi atualizada com sucesso!");
		}else
			System.out.println("\nA Conta numero: " + conta.getNumero() + " não foi encontrada!");
    }

    /**
     *  Apagar Conta
     * */
    @Override
    public void deletar(int numero) {
        var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			if(listaContas.remove(conta) == true)
				System.out.println("\nA Conta numero: " + numero + " foi deletada com sucesso!");
		}else
			System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
    }

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	// MÉTODOS AUXILIARES
	
	//  Método para gerar automaticamente o Número da Conta
	public int gerarNumero() {
		return ++ numero;
	}
	
	 // Método para buscar a Conta na Collection
	 
	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		
		return null;
	}
	
	/**
	 * Método para retornar o Tipo da Conta
	 * */
	public int retornaTipo(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta.getTipo();
			}
		}
		
		return 0;
	}

}
