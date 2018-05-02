package hz.cms.vo;

import java.util.List;

/**
 * Created by xhz on 2017/12/19.
 */
public class GenericType<T> {

    private T param;

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public static <T extends Comparable> int compare(T[] a,T b){
        int count =0;
        for(T c:a){
            if(c.compareTo(b)>0){
                count++;
            }
        }
        return count;
    }

    T getv(List<? extends T> l){
        return l.get(0);
    }
}
