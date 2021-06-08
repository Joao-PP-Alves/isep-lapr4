package eapli.base.ticket.domain;


import eapli.framework.domain.model.ValueObject;

public enum UrgencyTypes implements ValueObject {
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
