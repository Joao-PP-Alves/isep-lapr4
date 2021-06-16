grammar TaskScriptGrammar;

@parser::header { // classes a incluir
    import java.util.*;
    import java.lang.*;
    import java.io.*;
}

@parser::members {

}
init: exprs;

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

email : destination NEWLINE (STR|NUM)+ NEWLINE (body)+ SEMI;

body : ((STR|NUM|AT|PERCENT|MINUS) (((STR|NUM) EQ LBRACKET LBRACKET DOLLAR (STR|NUM) RBRACKET RBRACKET) (STR|NUM|AT|PERCENT|MINUS))?)+ NEWLINE;

destination: (STR|NUM)+ AT (STR|NUM)+ email_extension;

email_extension : (DOT (STR|NUM)+)* DOT 'pt'
                | (DOT (STR|NUM)+)* DOT 'com';

oper : EQ | NEQ | LT | GT | LTEQ | GTEQ ;

file : 'write to \'' filename '\''
          | 'read from \'' filename '\''
          ;

filename : (STR|NUM|UNDER|MINUS)+ extension;

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
DOLLAR : '$';
EURO : '€'|'£';


FILE_CATCHER : 'file:' | 'File:';
EMAIL_CATCHER: 'email:' | 'Email:';

STR: [A-Za-z]+;
//TEXT : STR[A-Za-z ]*;
//VAR_NAME : STR[A-Za-z0-9]*;
//FILE_NAME : STR[A-Za-z0-9 _\-]*;
NUM : [0-9]+;


NEWLINE : '\r'?'\n' ;

WS : [ \t]+ -> skip ; // ignora os espaços e tabs


