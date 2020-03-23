package listadpla;


public class ListaDE {
	
	private No sentinelaInicial = new No(null, null);
    private No sentinelaFinal = new No(null, null);
	private int tamanho = 0;
	
	public ListaDE() {
        this.sentinelaInicial.setProx(this.sentinelaFinal);
        this.sentinelaFinal.setAnt(this.sentinelaInicial);
    }

    //Metodo size
    public int tamanho() {
        return this.tamanho;
    }

    //Metodo isEmpty
    public boolean taVazia() {
        return tamanho == 0;
    }
    
    //Metodo display
    public void listar(No indice) {
    	if(indice != null) {
    		System.out.println(indice.getO());	
    		indice = indice.getProx();
    		listar(indice);
    	}
    	else {
    		System.out.println("A lista está vazia");
    	}
    }
    
    // Metodo before
    public No anterior(No atual) {
    	No ant = atual.getAnt();
		return ant;    
	}
    
    // Metodo after
    public No proximo(No atual) {
        return atual.getProx();
    }
    
    // eu estou trocando só o conteudo do nó
    public void substituicao(No no, Object objeto) {
        no.setO(objeto);
    }    

    // Troca a posição dos objetos dos nós
    public void trocaPosicao(No trocado, No trocador) {
    	Object temp = trocado.getO();
    	trocado.setO(trocador.getO());
    	trocador.setO(temp);
    }
    
    //metodo insertBefore
    public No inserirAntes(No atual, Object objeto) {
    	
    	No novo = new No(atual, atual.getAnt(), objeto);
    	atual.setAnt(novo);
    	novo.setProx(novo);	
    	
    	tamanho++;
    	return novo;
    }
    
   // Metodo inserAfter
    public No inserirDepois(No atual, Object objeto) {
    	No novo = new No(atual.getProx(), atual,objeto);
    	atual.setProx(novo);
    	novo.setAnt(novo);
    	tamanho++;
    	return novo;
    }

    
    //Metodo insertFirst
    public No inserirInicio(Object objeto) {
    	No novo = new No(sentinelaInicial.getProx(), sentinelaInicial, objeto);
    	sentinelaInicial.setProx(novo);
    	tamanho++;
    	return novo;
    }
    
    //Metodo insertLast 
    public void inserirFim(Object objeto) {
    	No novo = new No(sentinelaFinal, sentinelaFinal.getAnt(), objeto);
    	if(sentinelaInicial.getProx() == sentinelaFinal) {
    		sentinelaInicial.setProx(novo);
    		sentinelaFinal.setAnt(novo);
    	}
    	
    	else {
            No ant = sentinelaFinal.getAnt();
        	ant.setProx(novo);
    	}
    	tamanho++;
    }
    
    
    
    
    public No encontrar(Object objeto) {
    	No indice = sentinelaInicial.getProx();
    	while(objeto == indice.getO()) {
    		indice = indice.getProx();
    	}
    	return indice;
    }
    
    
    
    public boolean eInicial(No n) {
        return n.getAnt().getAnt() == null;
    }

   
    public boolean eUltimo(No n) {
        return n.getProx().getProx() == null;
    }
    
    public void remover(No n) {
        n.getAnt().setProx(n.getProx());
        n.getProx().setAnt(n.getAnt());
        n.setAnt(null); 
        n.setProx(null);
        this.tamanho--;
    }

}
