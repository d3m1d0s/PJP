grammar Language;

start : prog EOF ;

prog  : (expr ';')+ ;

expr  : expr op=('*'|'/') expr    # mul
      | expr op=('+'|'-') expr    # add
      | INT                       # int
      | OCT                       # oct
      | HEXA                      # hexa
      | '(' expr ')'              # par
      ;

ID    : [a-zA-Z]+ ;
INT   : [1-9][0-9]* ;
OCT   : '0'[0-7]* ;
HEXA  : '0x'[0-9a-fA-F]+ ;
WS    : [ \t\r\n]+ -> skip ;
