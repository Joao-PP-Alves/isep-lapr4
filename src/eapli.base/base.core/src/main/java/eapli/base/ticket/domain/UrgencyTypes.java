package eapli.base.ticket.domain;


public enum UrgencyTypes {
    REDUZIDA{
        @Override
        public String toString() {
            return "reduzida";
        }
    },
    MODERADA{
        @Override
        public String toString() {
            return "moderada";
        }
    },
    URGENTE{
        @Override
        public String toString() {
            return "urgente";
        }
    };

    @Override
    public String toString() {
        return super.toString();
    }
}
