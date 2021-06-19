package eapli.base.ticket.domain;


public enum TicketState {
    SUBMETIDO {
        @Override
        public String toString() {
            return "submetido";
        }
    },
    EM_APROVACAO {
        @Override
        public String toString() {
            return "em aprovacao";
        }
    },
    APROVADO {
        @Override
        public String toString() {
            return "aprovado";
        }
    },
    REJEITADO {
        @Override
        public String toString() {
            return "rejeitado";
        }
    },
    EM_RESOLUCAO {
        @Override
        public String toString() {
            return "em resolucao";
        }
    },
    RESOLVIDO {
        @Override
        public String toString() {
            return "resolvido";
        }
    };

    @Override
    public String toString() {
        return super.toString();
    }
}
