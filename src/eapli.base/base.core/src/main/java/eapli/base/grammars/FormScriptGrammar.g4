grammar FormScriptGrammar ;

@parser::header { // classes a incluir
    import java.util.*;
    import java.lang.*;
    import java.io.*;
}

@parser::members {

}


exprs : (expr NEWLINE?)* ;

expr : var SEMI
     | field SEMI
     | field
     | keyevent
     | keyevent SEMI
     ;

field : var COMMA (STR)+ COMMA (STR)+ COMMA type COMMA (STR)+
      | var COMMA (STR)+ COMMA (STR)+ COMMA type COMMA (STR)+ SIDE_BAR_RL dependencies
      ;

var : (STR|NUM)+;

dependencies : dependencies COMMA var
            | var
            ;

type : INT
     | STRING
     | FLOAT
     | BOOLEAN
     | LONG
     | DOUBLE
     ;

keyevent : var EQ (NUM | STR)+ unlock var (COMMA var)*
        ;

unlock : COLON COLON
        ;

/*
expr : ifstatement
     | file
     ;


ifstatement : IF LPAR VAR_NAME oper NUM RPAR 'then' returnable
            | IF LPAR VAR_NAME oper NUM RPAR 'then' returnable 'else' expr
            | 'else' returnable
            ;

oper: EQ | NEQ | LT | GT | LTEQ | GTEQ
    | size='.size' oper
    ;

returnable : 'true' | 'false'
            ;

file : 'write to \'' filename '\''
     | 'read from \'' filename '\''
     ;

filename : FILE_NAME extension
         | VAR_NAME extension;

extension : '.txt' | '.xsl' | '.xml' ;

*/


/* Var types */
INT : 'int';
BOOLEAN: 'boolean';
DOUBLE : 'double';
STRING : 'string' | 'String' ;
FLOAT : 'float' ;
LONG : 'long' | 'Long' ;

/* Comparison operators */
EQ		: '=' ;
NEQ		: '<>' ;
LTEQ	: '<=' ;
GTEQ	: '>=' ;
GT		: '>' ;
LT		: '<' ;

/* Text operators */
AMP		: '&' ;

/* Reference operators */
fragment ABS : '$' ;
fragment EXCL:  '!'  ;
COLON	: ':' ;
ATTRIB : ':=' ;
HASHTAG : '#' ;

/* Miscellaneous operators */
COMMA	: ',' ;
SEMI	: ';' ;
LPAR	: '(' ;
RPAR	: ')' ;
LBRACKET: '{' ;
RBRACKET: '}' ;
SIDE_BAR_RL: '/';
UNDER	: '_' ;
AT : '@' ;
DOT : '.' ;

//
CURRENCY_HEADER : ('#euro' | '#dollar' | '#pound') ;
EURO : '#euro';
CURRENCY : ('$' | '£' | '€') ;

IF : 'if'|'If'|'IF';
STR: [A-Za-z]+;
NUM : [0-9]+ ;


NEWLINE : '\r'?'\n' ;

WS : [ \t]+ -> skip ; // ignora os espaços e tabs

