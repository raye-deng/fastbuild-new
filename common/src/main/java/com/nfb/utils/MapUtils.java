package com.nfb.utils;

/**
 * Created by 蔻丁同学 on 2015/4/29.
 */

import org.apache.commons.collections.*;
import org.apache.commons.collections.map.*;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.Map.Entry;

public class MapUtils {
    public static final Map EMPTY_MAP = UnmodifiableMap.decorate(new HashMap(1));
    public static final SortedMap EMPTY_SORTED_MAP = UnmodifiableSortedMap.decorate(new TreeMap());
    private static final String INDENT_STRING = "    ";

    public MapUtils() {
    }

    public static Object getObject(Map map, Object key) {
        return map != null ? map.get(key) : null;
    }

    public static String getString(Map map, Object key) throws Exception {
        if (map != null) {
            Object answer = map.get(key);
            if (answer != null) {
                return answer.toString();
            }
        }

        return null;
    }


    public static Boolean getBoolean(Map map, Object key) {
        if (map != null) {
            Object answer = map.get(key);
            if (answer != null) {
                if (answer instanceof Boolean) {
                    return (Boolean) answer;
                }

                if (answer instanceof String) {
                    return new Boolean((String) answer);
                }

                if (answer instanceof Number) {
                    Number n = (Number) answer;
                    return n.intValue() != 0 ? Boolean.TRUE : Boolean.FALSE;
                }
            }
        }

        return null;
    }

    public static Number getNumber(Map map, Object key) {
        if (map != null) {
            Object answer = map.get(key);
            if (answer != null) {
                if (answer instanceof Number) {
                    return (Number) answer;
                }

                if (answer instanceof String) {
                    try {
                        String e = (String) answer;
                        return NumberFormat.getInstance().parse(e);
                    } catch (ParseException var4) {
                        logInfo(var4);
                    }
                }
            }
        }

        return null;
    }

    public static Byte getByte(Map map, Object key) {
        Number answer = getNumber(map, key);
        return answer == null ? null : (answer instanceof Byte ? (Byte) answer : new Byte(answer.byteValue()));
    }

    public static Short getShort(Map map, Object key) {
        Number answer = getNumber(map, key);
        return answer == null ? null : (answer instanceof Short ? (Short) answer : new Short(answer.shortValue()));
    }

    public static Integer getInteger(Map map, Object key) {
        Number answer = getNumber(map, key);
        return answer == null ? null : (answer instanceof Integer ? (Integer) answer : new Integer(answer.intValue()));
    }

    public static Long getLong(Map map, Object key) {
        Number answer = getNumber(map, key);
        return answer == null ? null : (answer instanceof Long ? (Long) answer : new Long(answer.longValue()));
    }

    public static Float getFloat(Map map, Object key) {
        Number answer = getNumber(map, key);
        return answer == null ? null : (answer instanceof Float ? (Float) answer : new Float(answer.floatValue()));
    }

    public static Double getDouble(Map map, Object key) {
        Number answer = getNumber(map, key);
        return answer == null ? null : (answer instanceof Double ? (Double) answer : new Double(answer.doubleValue()));
    }

    public static Map getMap(Map map, Object key) {
        if (map != null) {
            Object answer = map.get(key);
            if (answer != null && answer instanceof Map) {
                return (Map) answer;
            }
        }

        return null;
    }

    public static Object getObject(Map map, Object key, Object defaultValue) {
        if (map != null) {
            Object answer = map.get(key);
            if (answer != null) {
                return answer;
            }
        }

        return defaultValue;
    }

    public static String getString(Map map, Object key, String defaultValue) throws Exception {
        String answer = getString(map, key);
        if (answer == null) {
            if (defaultValue == null && "".equals(defaultValue)) {
                throw new Exception("默认值不能为空！");
            }
            answer = defaultValue;
        }

        return answer;
    }

    public static Boolean getBoolean(Map map, Object key, Boolean defaultValue) {
        Boolean answer = getBoolean(map, key);
        if (answer == null) {
            answer = defaultValue;
        }

        return answer;
    }

    public static Number getNumber(Map map, Object key, Number defaultValue) {
        Number answer = getNumber(map, key);
        if (answer == null) {
            answer = defaultValue;
        }

        return answer;
    }

    public static Byte getByte(Map map, Object key, Byte defaultValue) {
        Byte answer = getByte(map, key);
        if (answer == null) {
            answer = defaultValue;
        }

        return answer;
    }

    public static Short getShort(Map map, Object key, Short defaultValue) {
        Short answer = getShort(map, key);
        if (answer == null) {
            answer = defaultValue;
        }

        return answer;
    }

    public static Integer getInteger(Map map, Object key, Integer defaultValue) {
        Integer answer = getInteger(map, key);
        if (answer == null) {
            answer = defaultValue;
        }

        return answer;
    }

    public static Long getLong(Map map, Object key, Long defaultValue) {
        Long answer = getLong(map, key);
        if (answer == null) {
            answer = defaultValue;
        }

        return answer;
    }

    public static Float getFloat(Map map, Object key, Float defaultValue) {
        Float answer = getFloat(map, key);
        if (answer == null) {
            answer = defaultValue;
        }

        return answer;
    }

    public static Double getDouble(Map map, Object key, Double defaultValue) {
        Double answer = getDouble(map, key);
        if (answer == null) {
            answer = defaultValue;
        }

        return answer;
    }

    public static Map getMap(Map map, Object key, Map defaultValue) {
        Map answer = getMap(map, key);
        if (answer == null) {
            answer = defaultValue;
        }

        return answer;
    }

    public static boolean getBooleanValue(Map map, Object key) {
        Boolean booleanObject = getBoolean(map, key);
        return booleanObject == null ? false : booleanObject.booleanValue();
    }

    public static byte getByteValue(Map map, Object key) {
        Byte byteObject = getByte(map, key);
        return byteObject == null ? 0 : byteObject.byteValue();
    }

    public static short getShortValue(Map map, Object key) {
        Short shortObject = getShort(map, key);
        return shortObject == null ? 0 : shortObject.shortValue();
    }

    public static int getIntValue(Map map, Object key) {
        Integer integerObject = getInteger(map, key);
        return integerObject == null ? 0 : integerObject.intValue();
    }

    public static long getLongValue(Map map, Object key) {
        Long longObject = getLong(map, key);
        return longObject == null ? 0L : longObject.longValue();
    }

    public static float getFloatValue(Map map, Object key) {
        Float floatObject = getFloat(map, key);
        return floatObject == null ? 0.0F : floatObject.floatValue();
    }

    public static double getDoubleValue(Map map, Object key) {
        Double doubleObject = getDouble(map, key);
        return doubleObject == null ? 0.0D : doubleObject.doubleValue();
    }

    public static boolean getBooleanValue(Map map, Object key, boolean defaultValue) {
        Boolean booleanObject = getBoolean(map, key);
        return booleanObject == null ? defaultValue : booleanObject.booleanValue();
    }

    public static byte getByteValue(Map map, Object key, byte defaultValue) {
        Byte byteObject = getByte(map, key);
        return byteObject == null ? defaultValue : byteObject.byteValue();
    }

    public static short getShortValue(Map map, Object key, short defaultValue) {
        Short shortObject = getShort(map, key);
        return shortObject == null ? defaultValue : shortObject.shortValue();
    }

    public static int getIntValue(Map map, Object key, int defaultValue) {
        Integer integerObject = getInteger(map, key);
        return integerObject == null ? defaultValue : integerObject.intValue();
    }

    public static long getLongValue(Map map, Object key, long defaultValue) {
        Long longObject = getLong(map, key);
        return longObject == null ? defaultValue : longObject.longValue();
    }

    public static float getFloatValue(Map map, Object key, float defaultValue) {
        Float floatObject = getFloat(map, key);
        return floatObject == null ? defaultValue : floatObject.floatValue();
    }

    public static double getDoubleValue(Map map, Object key, double defaultValue) {
        Double doubleObject = getDouble(map, key);
        return doubleObject == null ? defaultValue : doubleObject.doubleValue();
    }

    public static Properties toProperties(Map map) {
        Properties answer = new Properties();
        if (map != null) {
            Iterator iter = map.entrySet().iterator();

            while (iter.hasNext()) {
                Entry entry = (Entry) iter.next();
                Object key = entry.getKey();
                Object value = entry.getValue();
                answer.put(key, value);
            }
        }

        return answer;
    }

    public static Map toMap(ResourceBundle resourceBundle) {
        Enumeration enumeration = resourceBundle.getKeys();
        HashMap map = new HashMap();

        while (enumeration.hasMoreElements()) {
            String key = (String) enumeration.nextElement();
            Object value = resourceBundle.getObject(key);
            map.put(key, value);
        }

        return map;
    }

    public static void verbosePrint(PrintStream out, Object label, Map map) {
        verbosePrintInternal(out, label, map, new ArrayStack(), false);
    }

    public static void debugPrint(PrintStream out, Object label, Map map) {
        verbosePrintInternal(out, label, map, new ArrayStack(), true);
    }

    protected static void logInfo(Exception ex) {
        System.out.println("INFO: Exception: " + ex);
    }

    private static void verbosePrintInternal(PrintStream out, Object label, Map map, ArrayStack lineage, boolean debug) {
        printIndent(out, lineage.size());
        if (map == null) {
            if (label != null) {
                out.print(label);
                out.print(" = ");
            }

            out.println("null");
        } else {
            if (label != null) {
                out.print(label);
                out.println(" = ");
            }

            printIndent(out, lineage.size());
            out.println("{");
            lineage.push(map);
            Iterator it = map.entrySet().iterator();

            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                Object childKey = entry.getKey();
                Object childValue = entry.getValue();
                if (childValue instanceof Map && !lineage.contains(childValue)) {
                    verbosePrintInternal(out, childKey == null ? "null" : childKey, (Map) childValue, lineage, debug);
                } else {
                    printIndent(out, lineage.size());
                    out.print(childKey);
                    out.print(" = ");
                    int lineageIndex = lineage.indexOf(childValue);
                    if (lineageIndex == -1) {
                        out.print(childValue);
                    } else if (lineage.size() - 1 == lineageIndex) {
                        out.print("(this Map)");
                    } else {
                        out.print("(ancestor[" + (lineage.size() - 1 - lineageIndex - 1) + "] Map)");
                    }

                    if (debug && childValue != null) {
                        out.print(' ');
                        out.println(childValue.getClass().getName());
                    } else {
                        out.println();
                    }
                }
            }

            lineage.pop();
            printIndent(out, lineage.size());
            out.println(debug ? "} " + map.getClass().getName() : "}");
        }
    }

    private static void printIndent(PrintStream out, int indent) {
        for (int i = 0; i < indent; ++i) {
            out.print("    ");
        }

    }

    public static Map invertMap(Map map) {
        HashMap out = new HashMap(map.size());
        Iterator it = map.entrySet().iterator();

        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            out.put(entry.getValue(), entry.getKey());
        }

        return out;
    }

    public static void safeAddToMap(Map map, Object key, Object value) throws NullPointerException {
        if (value == null) {
            map.put(key, "");
        } else {
            map.put(key, value);
        }

    }

    public static Map putAll(Map map, Object[] array) {
        map.size();
        if (array != null && array.length != 0) {
            Object obj = array[0];
            int i;
            if (obj instanceof Entry) {
                for (i = 0; i < array.length; ++i) {
                    Entry sub = (Entry) array[i];
                    map.put(sub.getKey(), sub.getValue());
                }
            } else if (obj instanceof KeyValue) {
                for (i = 0; i < array.length; ++i) {
                    KeyValue var5 = (KeyValue) array[i];
                    map.put(var5.getKey(), var5.getValue());
                }
            } else if (obj instanceof Object[]) {
                for (i = 0; i < array.length; ++i) {
                    Object[] var6 = (Object[]) ((Object[]) array[i]);
                    if (var6 == null || var6.length < 2) {
                        throw new IllegalArgumentException("Invalid array element: " + i);
                    }

                    map.put(var6[0], var6[1]);
                }
            } else {
                i = 0;

                while (i < array.length - 1) {
                    map.put(array[i++], array[i++]);
                }
            }

            return map;
        } else {
            return map;
        }
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    public static Map synchronizedMap(Map map) {
        return Collections.synchronizedMap(map);
    }

    public static Map unmodifiableMap(Map map) {
        return UnmodifiableMap.decorate(map);
    }

    public static Map predicatedMap(Map map, Predicate keyPred, Predicate valuePred) {
        return PredicatedMap.decorate(map, keyPred, valuePred);
    }

    public static Map typedMap(Map map, Class keyType, Class valueType) {
        return TypedMap.decorate(map, keyType, valueType);
    }

    public static Map transformedMap(Map map, Transformer keyTransformer, Transformer valueTransformer) {
        return TransformedMap.decorate(map, keyTransformer, valueTransformer);
    }

    public static Map fixedSizeMap(Map map) {
        return FixedSizeMap.decorate(map);
    }

    public static Map lazyMap(Map map, Factory factory) {
        return LazyMap.decorate(map, factory);
    }

    public static Map lazyMap(Map map, Transformer transformerFactory) {
        return LazyMap.decorate(map, transformerFactory);
    }

    public static Map orderedMap(Map map) {
        return ListOrderedMap.decorate(map);
    }

    public static Map multiValueMap(Map map) {
        return MultiValueMap.decorate(map);
    }

    public static Map multiValueMap(Map map, Class collectionClass) {
        return MultiValueMap.decorate(map, collectionClass);
    }

    public static Map multiValueMap(Map map, Factory collectionFactory) {
        return MultiValueMap.decorate(map, collectionFactory);
    }

    public static Map synchronizedSortedMap(SortedMap map) {
        return Collections.synchronizedSortedMap(map);
    }

    public static Map unmodifiableSortedMap(SortedMap map) {
        return UnmodifiableSortedMap.decorate(map);
    }

    public static SortedMap predicatedSortedMap(SortedMap map, Predicate keyPred, Predicate valuePred) {
        return PredicatedSortedMap.decorate(map, keyPred, valuePred);
    }

    public static SortedMap typedSortedMap(SortedMap map, Class keyType, Class valueType) {
        return TypedSortedMap.decorate(map, keyType, valueType);
    }

    public static SortedMap transformedSortedMap(SortedMap map, Transformer keyTransformer, Transformer valueTransformer) {
        return TransformedSortedMap.decorate(map, keyTransformer, valueTransformer);
    }

    public static SortedMap fixedSizeSortedMap(SortedMap map) {
        return FixedSizeSortedMap.decorate(map);
    }

    public static SortedMap lazySortedMap(SortedMap map, Factory factory) {
        return LazySortedMap.decorate(map, factory);
    }

    public static SortedMap lazySortedMap(SortedMap map, Transformer transformerFactory) {
        return LazySortedMap.decorate(map, transformerFactory);
    }
}
