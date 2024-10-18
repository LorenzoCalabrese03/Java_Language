package Entity.test;

/**
 * L'interfaccia Pagamento rappresenta un comportamento comune per tutti gli oggetti che devono
 * implementare un calcolo dell'importo totale.
 */
public interface Pagamento {
    
    /**
     * Calcola l'importo totale del pagamento.
     * 
     * @return L'importo totale calcolato.
     */
    double calcoloImporto();
}
