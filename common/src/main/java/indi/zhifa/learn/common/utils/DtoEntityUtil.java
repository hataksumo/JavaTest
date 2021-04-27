package indi.zhifa.learn.common.utils;

import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DtoEntityUtil Created by IntelliJ IDEA.
 *
 * @Author: 芝法酱
 * @Create 2021/3/16 10:34
 */
public class DtoEntityUtil {
    static DozerBeanMapper mapper;

    public static void init(){
        mapper = new DozerBeanMapper();
        mapper.setMappingFiles(Collections.singletonList("dozerJdk8Converters.xml"));
    }

    public static <D, E> E trans(D t, Class<E> clazz) {
        if (t == null) {
            return null;
        }
        return mapper.map(t, clazz);
    }

    public static <D, E> List<E> trans(D[] ts, Class<E> clazz) {
        List<E> es = new ArrayList<E>();
        if (ts == null) {
            return es;
        }

        for (D d : ts) {
            E e = (E) trans(d, clazz);
            if (e != null) {
                es.add(e);
            }
        }

        return es;
    }


    public static <D, E> List<E> trans(List<D> ts, Class<E> clazz) {
        List<E> es = new ArrayList<E>();
        if (ts == null) {
            return es;
        }
        for (D d : ts) {
            E e = (E) trans(d, clazz);
            if (e != null) {
                es.add(e);
            }
        }
        return es;
    }

    public static <T,D> void copy(T dst, D src){
        mapper.map(src, dst);
    }
}
