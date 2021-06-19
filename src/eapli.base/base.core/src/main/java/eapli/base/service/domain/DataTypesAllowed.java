package eapli.base.service.domain;


public enum DataTypesAllowed {
    STRING {
        @Override
        public String toString() {
            return "String";
        }
    },
    INT {
        @Override
        public String toString() {
            return "int";
        }
    },
    DOUBLE {
        @Override
        public String toString() {
            return "double";
        }
    }
}
