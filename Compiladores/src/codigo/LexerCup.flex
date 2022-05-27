package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
Letra=[a-zA-Z_]+
Digito=[0-9]+
espacio=[ ,\t,\r\n]+
GUION_B=[_]
espacio_cadena=[ ]
%{
     private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
//Palabras Reservadas
( set )      {return new Symbol(sym.Set, yychar, yyline, yytext());}
( elseif )   {return new Symbol(sym.Elseif, yychar, yyline, yytext());}
( else )     {return new Symbol(sym.Else, yychar, yyline, yytext());}
( if )       {return new Symbol(sym.If, yychar, yyline, yytext());}
( then )     {return new Symbol(sym.Then, yychar, yyline, yytext());}
( puts )     {return new Symbol(sym.Puts, yychar, yyline, yytext());}
( while )    {return new Symbol(sym.While, yychar, yyline, yytext());}
( expr )     {return new Symbol(sym.Expr, yychar, yyline, yytext());}
( switch )   {return new Symbol(sym.Switch, yychar, yyline, yytext());}
( default )  {return new Symbol(sym.Default, yychar, yyline, yytext());}
( continue ) {return new Symbol(sym.Continue, yychar, yyline, yytext());}
( break )    {return new Symbol(sym.Break, yychar, yyline, yytext());}
( for )    {return new Symbol(sym.For, yychar, yyline, yytext());}
( proc )    {return new Symbol(sym.Proc, yychar, yyline, yytext());}
( return )    {return new Symbol(sym.Return, yychar, yyline, yytext());}
( incr )    {return new Symbol(sym.Incr, yychar, yyline, yytext());}

( "$" ) {return new Symbol(sym.Dolar, yychar, yyline, yytext());}

//comentarios,espacio en blanco
{espacio} {/*Ignore*/} 
"#".* {/*Ignore*/}

//Operadores Aritmeticos
"+" {return new Symbol(sym.Suma, yychar, yyline, yytext());}
"-" {return new Symbol(sym.Resta, yychar, yyline, yytext());}
"*" {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}
"/" {return new Symbol(sym.Division, yychar, yyline, yytext());}
"**" {return new Symbol(sym.Exponente, yychar, yyline, yytext());}
"%" {return new Symbol(sym.Porcentaje, yychar, yyline, yytext());}

//Operadores Relacionales
"==" {return new Symbol(sym.Igual, yychar, yyline, yytext());}
"<" {return new Symbol(sym.Menor, yychar, yyline, yytext());}
">" {return new Symbol(sym.Mayor, yychar, yyline, yytext());}
"<=" {return new Symbol(sym.Menor_igual, yychar, yyline, yytext());}
">=" {return new Symbol(sym.Mayor_igual, yychar, yyline, yytext());}

//Operadores logicos
"&&" {return new Symbol(sym.And, yychar, yyline, yytext());}
"||" {return new Symbol(sym.Or, yychar, yyline, yytext());}
"!"  {return new Symbol(sym.Not, yychar, yyline, yytext());}

//Simbolos de Agrupacion
( "{" ) {return new Symbol(sym.Llave_a, yychar, yyline, yytext());}
( "}" ) {return new Symbol(sym.Llave_c, yychar, yyline, yytext());}
( "[" ) {return new Symbol(sym.Corchete_a, yychar, yyline, yytext());}
( "]" ) {return new Symbol(sym.Corchete_c, yychar, yyline, yytext());}
( "\"" ) {return new Symbol(sym.Comillas, yychar, yyline, yytext());}

//Operadores Relacionales para cadenas
eq {return new Symbol(sym.Igual_que, yychar, yyline, yytext());}
ne {return new Symbol(sym.No_igual_que, yychar, yyline, yytext());}
in {return new Symbol(sym.Listado_si, yychar, yyline, yytext());}
ni {return new Symbol(sym.Listado_no, yychar, yyline, yytext());}

//Operador Booleano
(true | false)      {return new Symbol(sym.Op_booleano, yychar, yyline, yytext());}

//Palabras
{Letra}{Letra}* {return new Symbol(sym.Cadena, yychar, yyline, yytext());}
//Identificadores
{Letra}({Letra}|{Digito}|GUION_B)*   {return new Symbol(sym.Identificador, yychar, yyline, yytext());}
//Numero
("(-"{Digito}+")")|{Digito}+  {return new Symbol(sym.Numero, yychar, yyline, yytext());}


//Punto y coma
( ";" ) {return new Symbol(sym.P_coma, yychar, yyline, yytext());}

//Errores
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}

