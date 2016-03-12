package br.com.munif.jsonspike;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.HashSet;


public class Programa {
    
    public static void main (String ... args) throws Exception{
        
        ObjectMapper mapper=new ObjectMapper();
        
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        Pessoa joao=new Pessoa("Joao da Silva",25);
        Pessoa maria=new Pessoa("Maria", 22);
        Pessoa pedro=new Pessoa("Pedro", 20);
        
        Grupo homens=new Grupo("Homens", new HashSet<>());
        Grupo mulheres=new Grupo("Mulheres", new HashSet<>());
        
        homens.getPessoas().add(joao);
        joao.setGrupo(homens);
        
        homens.getPessoas().add(pedro);
        pedro.setGrupo(homens);
        
        mulheres.getPessoas().add(maria);
        maria.setGrupo(mulheres);
        
        
        Grupo grupos[]={homens,mulheres};
        
        String json = mapper.writeValueAsString(grupos);
        
        System.out.println(json);
        
        System.out.println(mapper.writeValueAsString(maria));
        
       
        
    }
    
}
