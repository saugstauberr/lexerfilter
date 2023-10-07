lexer grammar Formats;

IP:  IP_Address '.' IP_Address '.' IP_Address '.' IP_Address;
TIME: HH ':' MMSS (':' MMSS)?;

fragment IP_Address: [1-9]?[0-9]| '1'[0-9][0-9] | '2'[0-4][0-9] | '2'[5][0-5];
fragment HH:  [0-1][0-9] | '2'[0-3];
fragment MMSS: [0-5][0-9] ;

WS : . -> skip;