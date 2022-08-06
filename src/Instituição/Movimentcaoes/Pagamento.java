package Instituição.Movimentcaoes;

import Personas.Data;

public class Pagamento extends Movimentacoes {
    private String tipo_pagamento; // Alguma observacao para identificar oque esta sendo pago


    public Pagamento(Data Data_transacao, float valor, String tipo_transacao, String tipo_pagamento) {
        super(Data_transacao, valor, tipo_transacao);
        this.tipo_pagamento = tipo_pagamento;
    }

    public String DadosPagamento()
    {
        return DadosMovimentacao() +";"+ tipo_pagamento;
    }


    public String getTipo_pagamento() {
        return this.tipo_pagamento;
    }

    public void setTipo_pagamento(String tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }




}
