lexer grammar Time;

//TIME:  HOUR ':' MINUTE ':' SECOND | HOUR ':' MINUTE;
TIME: HH ':' MMSS (':' MMSS)?;

fragment HH:  [0-1][0-9] | '2'[0-3]; // hour in 24 hour
fragment MMSS: [0-5][0-9] ; // minutes seconds

WS : . -> skip ; // skip spaces, tabs, newlines, \r (Windows)
