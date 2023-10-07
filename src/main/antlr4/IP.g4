lexer grammar IP;

IP:  Number '.' Number '.' Number '.' Number;

fragment Number: [1-9]?[0-9]| '1'[0-9][0-9] | '2'[0-4][0-9] | '2'[5][0-5];

WS : . -> skip;
