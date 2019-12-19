package utils;

import soot.*;

import java.util.List;

public class SootMethodForJavaH {
    public static String getDesc(final SootMethod method){
        final StringBuffer buffer = new StringBuffer();
        buffer.append("(");
        try {
            final List<Type> types = method.getParameterTypes();
            for (Type type : types){
                buffer.append(getDesc(type));
            }
            buffer.append(")");
            buffer.append(getDesc(method.getReturnType()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static String getDesc(final Type type){
        if (type instanceof PrimType || type instanceof VoidType){
            return getPrimitiveLetter(type);
        }
        if (type instanceof ArrayType){
            return "[" + getDesc(((ArrayType) type).getArrayElementType());
        }
        return "L" + getType(type) + ";";
    }

    public static String getType(final Type type){
        if (type instanceof ArrayType){
            return "[" + getDesc(((ArrayType) type).getArrayElementType());
        }
        if (type instanceof RefType){
            final String clsName = ((RefType) type).getClassName();
            return clsName.replaceAll("\\.", "/");
        }
        return getPrimitiveLetter(type);
    }

    public static String getPrimitiveLetter(final Type type){
        if (type instanceof IntType){
            return "I";
        }
        if (type instanceof VoidType){
            return "V";
        }
        if (type instanceof BooleanType){
            return "Z";
        }
        if (type instanceof CharType) {
            return "C";
        }
        if (type instanceof ByteType) {
            return "B";
        }
        if (type instanceof ShortType) {
            return "S";
        }
        if (type instanceof FloatType) {
            return "F";
        }
        if (type instanceof LongType) {
            return "J";
        }
        if (type instanceof DoubleType) {
            return "D";
        }
        throw new IllegalStateException("Type: " + type.toString() + " is not a primitive type");
    }
}
