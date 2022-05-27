package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
Letra=[a-zA-Z_]+
GUION_B=[_]
Digito=[0-9]+
espacio=[ ,\t,\r]+
espacio_cadena=[ ]
%{
    public String lexeme;
%}
%%
//Palabras Reservadas
set         {lexeme=yytext(); return Set;}
elseif      {lexeme=yytext(); return Elseif;}
else        {lexeme=yytext(); return Else;}
if          {lexeme=yytext(); return If;}
then        {lexeme=yytext(); return Then;}
puts        {lexeme=yytext(); return Puts;}
while       {lexeme=yytext(); return While;}
expr        {lexeme=yytext(); return Expr;}
switch      {lexeme=yytext(); return Switch;}
default     {lexeme=yytext(); return Default;}
continue    {lexeme=yytext(); return Continue;}
break       {lexeme=yytext(); return Break;}
for         {lexeme=yytext(); return For;}
proc        {lexeme=yytext(); return Proc;}
return      {lexeme=yytext(); return Return;}
incr        {lexeme=yytext(); return Incr;}

"$"     {lexeme=yytext(); return Dolar;}

//Linea,comentarios,espacio en blanco
{espacio} {/*Ignore*/}
"#".* {/*Ignore*/}
( "\n" ) {return Linea;}

//Operadores Aritmeticos
"+" {return Suma;}
"-" {return Resta;}
"*" {return Multiplicacion;}
"/" {return Division;}
"**" {return Exponente;}
"%" {return Porcentaje;}

//Operadores Relacionales
"==" {return Igual;}
"<" {return Menor;}
">" {return Mayor;}
"<=" {return Menor_igual;}
">=" {return Mayor_igual;}

//Operadores Relacionales para cadenas
eq {return Igual_que;}
ne {return No_igual_que;}
in {return Listado_si;}
ni {return Listado_no;}

//Operadores logicos
"&&" {return And;}
"||" {return Or;}
"!" {return Not;}

//Simbolos de Agrupacion
( "{" ) {lexeme=yytext(); return Llave_a;}
( "}" ) {lexeme=yytext(); return Llave_c;}
( "[" ) {lexeme = yytext(); return Corchete_a;}
( "]" ) {lexeme = yytext(); return Corchete_c;}
( "\"" ) {lexeme=yytext(); return Comillas;}

//Operadores Booleanos
(true | false)      {lexeme = yytext(); return Op_booleano;}


//palabras
{Letra}{Letra}* {lexeme=yytext(); return Cadena;}
//Identifiadores
{Letra}({Letra}|{Digito}|GUION_B)* {lexeme=yytext(); return Identificador;}
//Numeros
("(-"{Digito}+")")|{Digito}+ {lexeme=yytext(); return Numero;}

//Punto y coma
( ";" ) {lexeme=yytext(); return P_coma;}

//Errores
 . {return ERROR;}
