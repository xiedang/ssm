package com.xiedang.www.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/12/24 16:42
 */
public class SheetData<T> {
    /**
     * 替换占位符map
     */
    private Map<String, Object> map = new HashMap<>(16);

    /**
     * excel主体部分
     */
    private List<List<T>> lists = new ArrayList<>();

    public Object get(String key) {
        return map.get(key);
    }

    /**
     * sheet name
     */
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public SheetData(String name) {
        this.name = name;
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }

    public void remove(String key) {
        map.remove(key);
    }

    /**
     * 清理map存储和数据存储
     */
    public void clear() {
        map.clear();
        lists.clear();
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<List<T>> getLists() {
        return lists;
    }

    public void setLists(List<List<T>> lists) {
        this.lists = lists;
    }
}
