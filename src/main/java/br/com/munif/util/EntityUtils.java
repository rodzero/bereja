package br.com.munif.util;

import br.com.munif.bereja.entidades.util.SuperEntidade;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Id;

/**
 * Conjunto de métodos para facilitar tarefas em entidades.
 * @author munif
 */
public class EntityUtils {
    /**
     * Obtem o valor da chave primária de uma entidade. O método procura o
     * atributo com a anotação ID na classe e nas superclasses
     *
     * @param entidade entidade que deseja-se a chave
     * @return valor da chave
     */
    public static Object getId(SuperEntidade entidade) {
        return entidade.getId();
    }

    /**
     * Obtém o valor do atributo a partir de seu nome e do objeto que o contém
     *
     * @param entidade
     * @param attrName
     * @return
     */
    public static Object getAttributeValue(Object entidade, String attrName) {
        try {
            Field f = entidade.getClass().getDeclaredField(attrName);
            f.setAccessible(true);
            return f.get(entidade);
        } catch (Exception ex) {
            System.out.println("Não foi possível encontrar o atributo " + attrName + " na classe " + entidade.getClass().getName()+" "+ ex);
        }
        return null;
    }



    /**
     * Método recursivo para descobrir todos os atributos da entidade, incluindo
     * os das superclasses, se existirem
     *
     * @param classe classe da entidade
     * @return um ArrayList com os atributos (Fields) da entidade
     */
    public static List<Field> getAtributos(Class classe) {
        List<Field> lista = new ArrayList<>();
        if (!classe.getSuperclass().equals(Object.class)) {
            lista.addAll(getAtributos(classe.getSuperclass()));
        }
        for (Field f : classe.getDeclaredFields()) {
            if (Modifier.isStatic(f.getModifiers())) {
                continue;
            }
            lista.add(f);
        }
        return lista;
    }

    /**
     * Método que retorna o primeiro atributo da classe de entidade. Não retorna
     * atributos estáticos. Evita retorna atributos com a anotação
     * Id, isto é, caso exista algum atributo não estático sem esta
     * anotação, este será retornado. Este método é destinado a construção de
     * consultas genéricas.
     *
     * @param classe Classe da entidade.
     * @return
     */
    public static Field primeiroAtributo(Class classe) {
        Field f = null;
        for (Field atributo : getAtributos(classe)) {
            if (Modifier.isStatic(atributo.getModifiers())) {
                continue;
            }
            if (f == null) {
                f = atributo;
            }
            if (!atributo.isAnnotationPresent(Id.class)) {
                return atributo;
            } else if (f == null) {
                f = atributo;
            }
        }
        return f;
    }
    
}
