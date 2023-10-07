lexer grammar Time;

TIME: HH ':' MMSS (':' MMSS)?;

fragment HH:  [0-1][0-9] | '2'[0-3];
fragment MMSS: [0-5][0-9];

WS : . -> skip;
