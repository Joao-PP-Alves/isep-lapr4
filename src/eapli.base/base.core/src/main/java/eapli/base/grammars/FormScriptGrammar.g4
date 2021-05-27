grammar FormScriptGrammar ;

exprs : (expr? NEWLINE)* ;

expr : 'If' ifstatement
     | 'if' ifstatement
     | file
     ;

ifstatement : '(' VAR_NAME oper NUM ')' 'then' returnable
            | '(' VAR_NAME oper NUM ')' 'then' returnable 'else' expr
            | 'else' returnable
            ;

oper: TK_EQ | TK_NEQ | TK_LT | TK_GT | TK_LTE | TK_GTE
    | 'size' oper
    ;

returnable : 'true' | 'false'
            ;

file : 'write to \'' filename '\''
     | 'read from \'' filename '\''
     ;

filename : VAR_NAME extension;

extension : '.txt' | '.xsl' | '.xml' ;

VAR_NAME : [A-Za-z][A-Za-z0-9]*;
NUM : [0-9]+;

TK_EQ  : '='    ;
TK_NEQ : '<''>' ;
TK_LT  : '<'    ;
TK_GT  : '>'    ;
TK_LTE : '<''=' ;
TK_GTE : '>''=' ;

NEWLINE : '\r'?'\n' ;

WS : [ \t]+ -> skip ; // ignora os espaços e tabs

