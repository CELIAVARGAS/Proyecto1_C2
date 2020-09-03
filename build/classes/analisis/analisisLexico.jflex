package analisis;
import java_cup.runtime.Symbol;

%%

%{
%}


%cup
%class scanner
%public
%line
%char
%column
%full

comentarioS= [\/][\/][^"\n"]*[\n]
comentarioC= [\/][\*][^"*/"]*[\*][\/]


/*PALABRAS RESERVADAS*/
terminal1 = "terminal"
noTerminal = "no terminal"
nombre = "nombre"
version = "version"
autor = "autor"
lanzamiento = "lanzamiento"
extension = "extension"
entero = "entero"
real = "real"
cadena1 = "cadena"

/*SIMBOLOS*/
corcheteAbierto = [\[]
corcheteCerrado = [\]]
parentesisAbierto = [\(]
parentesisCerrado = [\)]
coma = [\,]
igual = [\=]
dosPuntos = [\:]
puntoComa = [\;]
separador = "%%"

/*LEXEMAS*/
identificador=[[\_][a-zA-ZÀ-ÿ]]+[[a-zA-ZÀ-ÿ][0-9][\_]]*
numeroEntero=[0-9]+
numeroVersion = [0-9]+[[.][0-9]]*

/*SIMBOLOS_ER*/
opcional = "?"
muchasVeces= "*"
unoOmas = "+"
barraO = "|"
ignorar = "&"

numeros = "[0-9]"
letras = "[a-z]"
nuevaLinea = (\\)"n"
tabulador = (\\)"t"
espacioBlanco = (\\)"b"
caracter = [\"][^"\""]*[\"]

texto = [\{][^"}"]*[\}]

/*ESPACIOS*/
Espacios   = [\ \r\t\f]
Enter   = [\ \n]


%%

<YYINITIAL> {comentarioS}     
{ 
        System.out.println(" Caracter comentarioS '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
}

<YYINITIAL> {comentarioC}     
{ 
        System.out.println(" Caracter comentarioC '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
}

<YYINITIAL> {terminal1}     
{ 
        System.out.println(" Caracter terminal1 '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.terminal1, yyline, yycolumn,yytext());
}

<YYINITIAL> {noTerminal}     
{ 
        System.out.println(" Caracter noTerminal '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.noTerminal, yyline, yycolumn,yytext());
}

<YYINITIAL> {nombre}     
{ 
        System.out.println(" Caracter nombre '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.nombre, yyline, yycolumn,yytext());
}

<YYINITIAL> {version}     
{ 
        System.out.println(" Caracter version '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.version, yyline, yycolumn,yytext());
}

<YYINITIAL> {autor}     
{ 
        System.out.println(" Caracter autor  '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.autor, yyline, yycolumn,yytext());
}

<YYINITIAL> {lanzamiento}     
{ 
        System.out.println(" Caracter lanzamiento '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.lanzamiento, yyline, yycolumn,yytext());
}

<YYINITIAL> {extension}     
{ 
        System.out.println(" Caracter extension '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.extension, yyline, yycolumn,yytext());
}

<YYINITIAL> {entero}    
{ 
        System.out.println(" Caracter  entero '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.entero, yyline, yycolumn,yytext());
}

<YYINITIAL> {real}     
{ 
        System.out.println(" Caracter real '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.real, yyline, yycolumn,yytext());
}


<YYINITIAL> {cadena1}     
{ 
        System.out.println(" Caracter cadena1 '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.cadena1, yyline, yycolumn,yytext());
}

<YYINITIAL> {corcheteAbierto}     
{ 
        System.out.println(" Caracter corcheteAbierto '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.corcheteAbierto, yyline, yycolumn,yytext());
}

<YYINITIAL> {corcheteCerrado}     
{ 
        System.out.println(" Caracter corcheteCerrado '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.corcheteCerrado, yyline, yycolumn,yytext());
}

<YYINITIAL> {parentesisAbierto}     
{ 
        System.out.println(" Caracter parentesisAbierto '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.parentesisAbierto, yyline, yycolumn,yytext());
}

<YYINITIAL> {parentesisCerrado}     
{ 
        System.out.println(" Caracter parentesisCerrado '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.parentesisCerrado, yyline, yycolumn,yytext());
}

<YYINITIAL> {coma}     
{ 
        System.out.println(" Caracter coma '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.coma, yyline, yycolumn,yytext());
}

<YYINITIAL> {igual}     
{ 
        System.out.println(" Caracter igual '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.igual, yyline, yycolumn,yytext());
}

<YYINITIAL> {dosPuntos}     
{ 
        System.out.println(" Caracter dosPuntos '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.dosPuntos, yyline, yycolumn,yytext());
}

<YYINITIAL> {puntoComa}     
{ 
        System.out.println(" Caracter puntoComa '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.puntoComa, yyline, yycolumn,yytext());
}

<YYINITIAL> {separador}     
{ 
        System.out.println(" Caracter separador '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.separador, yyline, yycolumn,yytext());
}


<YYINITIAL> {identificador}     
{ 
        System.out.println(" Caracter identificador '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.identificador, yyline, yycolumn,yytext());
}


<YYINITIAL> {numeroEntero}     
{ 
        System.out.println(" Caracter numeroEntero '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.numeroEntero, yyline, yycolumn,yytext());
}

<YYINITIAL> {numeroVersion}     
{ 
        System.out.println(" Caracter numeroVersion '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.numeroVersion, yyline, yycolumn,yytext());
}


<YYINITIAL> {opcional}     
{ 
        System.out.println(" Caracter opcional '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.opcional, yyline, yycolumn,yytext());
}

<YYINITIAL> {unoOmas}     
{ 
        System.out.println(" Caracter unoOmas '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.unoOmas, yyline, yycolumn,yytext());
}

<YYINITIAL> {muchasVeces}     
{ 
        System.out.println(" Caracter muchasVeces '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.muchasVeces, yyline, yycolumn,yytext());
}

<YYINITIAL> {barraO}     
{ 
        System.out.println(" Caracter barraO '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.barraO, yyline, yycolumn,yytext());
}

<YYINITIAL> {ignorar}     
{ 
        System.out.println(" Caracter ignorar '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.ignorar, yyline, yycolumn,yytext());
}

<YYINITIAL> {numeros}     { 
        System.out.println(" Caracter numeros '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.numeros, yyline, yycolumn,yytext());
}

<YYINITIAL> {letras}     
{ 
        System.out.println(" Caracter letras '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.letras, yyline, yycolumn,yytext());
}

<YYINITIAL> {nuevaLinea}     
{ 
        System.out.println(" Caracter nuevaLinea '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.nuevaLinea, yyline, yycolumn,yytext());
}

<YYINITIAL> {tabulador}     
{ 
        System.out.println(" Caracter tabulador '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.tabulador, yyline, yycolumn,yytext());
}

<YYINITIAL> {espacioBlanco}     
{ 
        System.out.println(" Caracter espacioBlanco '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.espacioBlanco, yyline, yycolumn,yytext());
}

<YYINITIAL> {caracter}     
{ 
        System.out.println(" Caracter caracter '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.caracter, yyline, yycolumn,yytext());
}

<YYINITIAL> {texto}     
{ 
        System.out.println(" Caracter texto '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn);
        return new Symbol(sym.texto, yyline, yycolumn,yytext());
}


<YYINITIAL> {Espacios}     
{}

<YYINITIAL> {Enter}      
{}

<YYINITIAL> [^]    
{ 
        System.out.println("Error en caracter ");
}

