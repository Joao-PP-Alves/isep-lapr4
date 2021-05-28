grammar TaskScriptGrammar;

exprs : (expr? NEWLINE)* ;

expr : FILE_CATCHER file
     | EQ operation (semi_op)*
     | EMAIL_CATCHER email
     ;

operation : NUM oper NUM
          | NUM (MULTI|DIV) NUM
          | NUM (PLUS|MINUS) NUM
          | NUM POWER NUM
          | NUM PERCENT NUM
          ;

semi_op : oper NUM
        | (MULTI|DIV) NUM
        | (PLUS|MINUS) NUM
        | POWER NUM
        | PERCENT NUM
        ;

email : destination NEWLINE (TEXT|VAR_NAME|FILE_NAME) NEWLINE ((TEXT|VAR_NAME|FILE_NAME) NEWLINE)+ SEMI;

destination: (TEXT|VAR_NAME|FILE_NAME) AT (TEXT|VAR_NAME|FILE_NAME) email_extension;

email_extension : (DOT TEXT)* DOT 'pt'
                | (DOT TEXT)* DOT 'com';

oper : EQ | NEQ | LT | GT | LTEQ | GTEQ ;

file : 'write to \'' filename '\''
          | 'read from \'' filename '\''
          ;

filename : FILE_NAME extension
         | TEXT extension
         | VAR_NAME extension
         ;

extension : '.txt' | '.xsl' | '.xml' ;



/* Comparison operators */
EQ		: '=' ;
NEQ		: '<>' ;
LTEQ	: '<=' ;
GTEQ	: '>=' ;
GT		: '>' ;
LT		: '<' ;

/* Arithmetic operators */
PLUS	: '+' ;
MINUS	: '-' ;
MULTI	: '*' ;
DIV		: '/' ;
POWER	: '^' ;
PERCENT : '%' ;

COMMA	: ',' ;
SEMI	: ';' ;
LPAR	: '(' ;
RPAR	: ')' ;
LBRACKET: '{' ;
RBRACKET: '}' ;
UNDER	: '_' ;
AT : '@' ;
DOT : '.' ;

FILE_CATCHER : 'file:' | 'File:';
EMAIL_CATCHER: 'email:' | 'Email:';

TEXT : [A-Za-z][A-Za-z ]*;
VAR_NAME : [A-Za-z][A-Za-z0-9]*;
FILE_NAME : [A-Za-z][A-Za-z0-9 _\-]*;
NUM : [0-9]+;


NEWLINE : '\r'?'\n' ;

WS : [ \t]+ -> skip ; // ignora os espaços e tabs


